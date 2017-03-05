package geosolar.cassandra.core;

import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CassandraMappingManager {

    private MappingManager manager;

    @Autowired
    private CassandraSessionManager cassandraSessionManager;

    @PostConstruct
    public void createManager() {
        manager = new MappingManager(cassandraSessionManager.getSession());
    }

    public MappingManager getManager() {
        return manager;
    }

}
