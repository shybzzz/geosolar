package geosolar.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CassandraClusterManager {

    public void executeInSession(Function<Session, ?> execute) {
        Cluster cluster = Cluster.builder()
                .withPort(9042)
                .addContactPoints("127.0.0.1").build();
        Session session = cluster.connect("geosolar");
        execute.apply(session);
        session.close();
        cluster.close();
    }

}
