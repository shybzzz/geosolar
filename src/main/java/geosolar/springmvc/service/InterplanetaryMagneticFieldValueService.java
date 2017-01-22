package geosolar.springmvc.service;

import com.datastax.driver.core.Row;
import geosolar.cassandra.CassandraClusterManager;
import geosolar.springmvc.domain.InterplanetaryMagneticFieldValue;
import geosolar.utils.matlab.MatFileBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InterplanetaryMagneticFieldValueService {

    @Autowired
    private CassandraClusterManager cassandraClusterManager;

    public List<InterplanetaryMagneticFieldValue> getInterplanetaryMagneticFieldValues() {

        String cqlStatement = "SELECT * FROM interplanetary_magnetic_field_values";
        ArrayList<InterplanetaryMagneticFieldValue> values = new ArrayList<>();

        cassandraClusterManager.executeInSession(session -> {
            for (Row row : session.execute(cqlStatement)) {
                values.add(new InterplanetaryMagneticFieldValue(
                        row.getInt("YR"),
                        row.getInt("MO"),
                        row.getInt("DA"),
                        row.getInt("HHMM"),
                        row.getDouble("Bz")
                ));
            }
            return null;
        });

        return values;
    }

    public File getMatFile() throws IOException {
        return new MatFileBuilder()
                .addDoublesList("interplanetaryMagneticFieldValues",
                        getInterplanetaryMagneticFieldValues(),
                        val -> new double[]{
                                val.getYear(),
                                val.getMonth(),
                                val.getDay(),
                                val.getHhmm(),
                                val.getBz(),
                        })
                .buildMat("interplanetaryMagneticFieldValues.mat");
    }
}
