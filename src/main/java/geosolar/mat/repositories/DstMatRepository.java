package geosolar.mat.repositories;

import geosolar.domain.Dst;
import geosolar.mat.generic.MatFileBuilder;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Repository
public class DstMatRepository {

    private static final Function<Dst, double[]> DST_2_DOUBLES = dst -> new double[]{
            dst.getYear(),
            dst.getMonth(),
            dst.getDay(),
            dst.getHour(),
            dst.getValue(),
    };

    public File getMatFile(List<Dst> dsts) throws IOException {
        return new MatFileBuilder()
                .addDoublesList("dst", dsts, DST_2_DOUBLES)
                .buildMat("dst.mat");
    }

}
