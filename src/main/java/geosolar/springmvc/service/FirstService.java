package geosolar.springmvc.service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import geosolar.springmvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;

/**
 * Created by osboxes on 11/09/16.
 */

@Service
public class FirstService {

    public List<User> getMyUsers() {
        return asList(new User("Rostyk"), new User("Ira"), new User("Hebels"), new User("Oleg"));
    }

    public List<User> getCassandraUsers() {
        Cluster cluster = Cluster.builder().withPort(9042).addContactPoints("127.0.0.1").build();
        Session session = cluster.connect("sampledb");
        String cqlStatement = "SELECT * FROM emp";
        ArrayList<User> users = new ArrayList<>();

        for (Row row : session.execute(cqlStatement)) {
            String name = row.getString(2);
            String surname = row.getString(3);
            users.add(new User(format("%1s %2s", name, surname)));
        }

        session.close();
        cluster.close();

        return users;
    }

}
