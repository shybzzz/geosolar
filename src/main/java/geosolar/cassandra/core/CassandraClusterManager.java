package geosolar.cassandra.core;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CassandraClusterManager {

    private static final int CASSANDRA_PORT = 9042;
    private static final String CONTACT_POINTS = "127.0.0.1";

    private Cluster cluster;

    @PostConstruct
    public void rebuildCluster() {
        closeCluster();
        buildCluster();
    }

    @PreDestroy
    public void destroyCluster() {
        closeCluster();
    }

    private void closeCluster() {
        if (this.cluster != null) {
            this.cluster.close();
        }
    }

    private void buildCluster() {
        this.cluster = Cluster.builder()
                .withPort(CASSANDRA_PORT)
                .addContactPoints(CONTACT_POINTS).build();
    }

    Session connectKeyspace(String keyspace) {
        return cluster.connect(keyspace);
    }

}
