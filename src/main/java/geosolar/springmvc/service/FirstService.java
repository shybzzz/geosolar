package geosolar.springmvc.service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import geosolar.springmvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by osboxes on 11/09/16.
 */

@Service
public class FirstService {

    public List<User> getMyUsers() {
        return asList(new User("Rostyk"), new User("Ira"), new User("Hebels"), new User("Oleg"));
    }

    public String getKunderaUsers() {

        /*Map<String, String> props = new HashMap<>();
        props.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("emp", props);
//        EntityManager em = managerFactory.createEntityManager();
//
////        em.persist(user);
//        em.close();
        managerFactory.close();
*/
        return "Something happened to Cassandra here and entity manager factory is created";
    }

    public ArrayList<String> getCassandraUsers() {
        Cluster cluster = Cluster.builder().withPort(9042).addContactPoints("127.0.0.1").build();
        Session session = cluster.connect("sampledb");
        String cqlStatement = "SELECT * FROM emp";
        ArrayList<String> strings = new ArrayList<>();

        for (Row row : session.execute(cqlStatement)) {
            strings.add(row.toString());
        }

        session.close();
        cluster.close();

        return strings;
    }

}
