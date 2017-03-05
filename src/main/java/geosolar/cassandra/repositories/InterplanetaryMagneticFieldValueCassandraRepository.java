package geosolar.cassandra.repositories;

import geosolar.cassandra.accessors.InterplanetaryMagneticFieldValueAccessor;
import geosolar.cassandra.core.CassandraMappingManager;
import geosolar.cassandra.generic.SessionOperations;
import geosolar.domain.InterplanetaryMagneticFieldValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Function;

import static geosolar.domain.InterplanetaryMagneticFieldValue.*;
import static java.util.Arrays.asList;

@Repository
public class InterplanetaryMagneticFieldValueCassandraRepository {

    private static final List<String> INTERPLANETARY_MAGNETIC_FIELD_VALUE_FIELDS = asList(ID_COLUMN, YEAR_COLUMN, MONTH_COLUMN, DAY_COLUMN, TIME_COLUMN, BZ_COLUMN);
    private static final Function<InterplanetaryMagneticFieldValue, List<Object>> INTERPLANETARY_MAGNETIC_FIELD_VALUE_2_OBJECTS = interplanetaryMagneticFieldValue -> asList(
            interplanetaryMagneticFieldValue.getId(),
            interplanetaryMagneticFieldValue.getYear(),
            interplanetaryMagneticFieldValue.getMonth(),
            interplanetaryMagneticFieldValue.getDay(),
            interplanetaryMagneticFieldValue.getHhmm(),
            interplanetaryMagneticFieldValue.getBz()
    );

    private InterplanetaryMagneticFieldValueAccessor accessor;

    @Autowired
    SessionOperations sessionOperations;

    @Autowired
    CassandraMappingManager cassandraMappingManager;

    @PostConstruct
    public void createAccessor() {
        accessor = cassandraMappingManager.getManager().createAccessor(InterplanetaryMagneticFieldValueAccessor.class);
    }

    public List<InterplanetaryMagneticFieldValue> getAll() {
        return accessor.getAll().all();
    }

    public void add(List<InterplanetaryMagneticFieldValue> interplanetaryMagneticFieldValues) {
        sessionOperations.add(
                INTERPLANETARY_MAGNETIC_FIELD_VALUE_TABLE,
                INTERPLANETARY_MAGNETIC_FIELD_VALUE_FIELDS,
                interplanetaryMagneticFieldValues,
                INTERPLANETARY_MAGNETIC_FIELD_VALUE_2_OBJECTS
        );
    }
}
