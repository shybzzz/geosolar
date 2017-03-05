package geosolar.cassandra.repositories;

import geosolar.cassandra.accessors.DstAccessor;
import geosolar.cassandra.core.CassandraMappingManager;
import geosolar.domain.Dst;
import geosolar.cassandra.generic.SessionOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Function;

import static geosolar.domain.Dst.*;
import static java.util.Arrays.asList;

@Repository
public class DstCassandraRepository {

    private static final List<String> DST_FIELDS = asList(ID_COLUMN, YEAR_COLUMN, MONTH_COLUMN, DAY_COLUMN, HOUR_COLUMN, VALUE_COLUMN);
    private static final Function<Dst, List<Object>> DST_2_OBJECTS = dst -> asList(
            dst.getId(),
            dst.getYear(),
            dst.getMonth(),
            dst.getDay(),
            dst.getHour(),
            dst.getValue()
    );

    private DstAccessor accessor;

    @Autowired
    SessionOperations sessionOperations;

    @Autowired
    private CassandraMappingManager cassandraMappingManager;

    @PostConstruct
    public void createAccessor() {
        accessor = cassandraMappingManager.getManager().createAccessor(DstAccessor.class);
    }

    public List<Dst> getAll() {
        return accessor.getAll().all();
    }

    public void add(List<Dst> dsts) {
        sessionOperations.add(DST_TABLE, DST_FIELDS, dsts, DST_2_OBJECTS);
    }
}
