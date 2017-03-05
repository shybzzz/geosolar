package geosolar.cassandra.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import geosolar.domain.InterplanetaryMagneticFieldValue;

@Accessor
public interface InterplanetaryMagneticFieldValueAccessor {

    @Query("SELECT * FROM interplanetary_magnetic_field_values")
    Result<InterplanetaryMagneticFieldValue> getAll();

}
