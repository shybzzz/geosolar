package geosolar.cassandra.core;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CassandraSessionManager {

    public static final String GEOSOLAR_KEYSPACE = "geosolar";

    private Session session;

    @Autowired
    private CassandraClusterManager cassandraClusterManager;

    @PostConstruct
    public void resetSession() {
        closeSession();
        createSession();
    }

    @PreDestroy
    public void destroySession() {
        closeSession();
    }

    private void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    private void createSession() {
        session = cassandraClusterManager.connectKeyspace(GEOSOLAR_KEYSPACE);
    }

    Session getSession() {
        return session;
    }

    public void execute(Statement statement) {
        session.execute(statement);
    }
}
