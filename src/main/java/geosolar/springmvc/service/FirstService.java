package geosolar.springmvc.service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import geosolar.springmvc.domain.Dst;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirstService {

    public List<Dst> getDstByHour(int hour) {
        Cluster cluster = Cluster.builder().withPort(9042).addContactPoints("127.0.0.1").build();
        Session session = cluster.connect("geosolar");
        String cqlStatement = "SELECT * FROM dst";
        ArrayList<Dst> dsts = new ArrayList<>();

        for (Row row : session.execute(cqlStatement)) {
            dsts.add(new Dst(
                    row.getInt("yy"),
                    row.getInt("mo"),
                    row.getInt("da"),
                    row.getInt("hh"),
                    row.getDouble("value")
            ));
        }

        session.close();
        cluster.close();

        return dsts;
    }

}
