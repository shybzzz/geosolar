package geosolar.cassandra.generic;

import com.datastax.driver.core.querybuilder.Batch;
import geosolar.cassandra.core.CassandraSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

import static com.datastax.driver.core.querybuilder.QueryBuilder.insertInto;
import static com.datastax.driver.core.querybuilder.QueryBuilder.unloggedBatch;
import static geosolar.cassandra.core.CassandraSessionManager.GEOSOLAR_KEYSPACE;

@Component
public class SessionOperations {

    @Autowired
    CassandraSessionManager cassandraSessionManager;

    public <T> void add(String table, List<String> fields, List<T> values, Function<T, List<Object>> valueResolver) {
        Batch batch = unloggedBatch();
        for (T v : values) {
            batch.add(insertInto(GEOSOLAR_KEYSPACE, table).values(fields, valueResolver.apply(v)));
        }
        cassandraSessionManager.execute(batch);

    }

}
