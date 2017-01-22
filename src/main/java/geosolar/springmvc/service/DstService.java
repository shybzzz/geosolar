package geosolar.springmvc.service;

import com.datastax.driver.core.Row;
import geosolar.cassandra.CassandraClusterManager;
import geosolar.springmvc.domain.Dst;
import geosolar.utils.matlab.MatFileBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DstService {

    @Autowired
    private CassandraClusterManager cassandraClusterManager;

    public List<Dst> getDst() {
        String cqlStatement = "SELECT * FROM dst";
        ArrayList<Dst> dsts = new ArrayList<>();
        cassandraClusterManager.executeInSession(session -> {
            for (Row row : session.execute(cqlStatement)) {
                dsts.add(new Dst(
                        row.getInt("yy"),
                        row.getInt("mo"),
                        row.getInt("da"),
                        row.getInt("hh"),
                        row.getDouble("value")
                ));
            }
            return null;
        });

        return dsts;
    }

    public File getMatFile() throws IOException {
        return new MatFileBuilder()
                .addDoublesList("dst",
                        getDst(),
                        dst -> new double[]{
                                dst.getYear(),
                                dst.getMonth(),
                                dst.getDay(),
                                dst.getHour(),
                                dst.getValue(),
                        })
                .buildMat("dst.mat");
    }
}
