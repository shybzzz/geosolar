package geosolar.cassandra.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import geosolar.domain.Dst;

@Accessor
public interface DstAccessor {

    @Query("SELECT * FROM dst")
    Result<Dst> getAll();

}
