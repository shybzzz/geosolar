package geosolar.mat.repositories;

import geosolar.domain.InterplanetaryMagneticFieldValue;
import geosolar.mat.generic.MatFileBuilder;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Repository
public class InterplanetaryMagneticFieldValueMatRepository {

    private static final Function<InterplanetaryMagneticFieldValue, double[]> INTERPLANETARY_MAGNETIC_FIELD_VALUE_2_DOUBLES = dst -> new double[]{
            dst.getYear(),
            dst.getMonth(),
            dst.getDay(),
            dst.getHhmm(),
            dst.getBz(),
    };

    public File getMatFile(List<InterplanetaryMagneticFieldValue> interplanetaryMagneticFieldValues) throws IOException {
        return new MatFileBuilder()
                .addDoublesList(
                        "interplanetaryMagneticFieldValue",
                        interplanetaryMagneticFieldValues,
                        INTERPLANETARY_MAGNETIC_FIELD_VALUE_2_DOUBLES
                ).buildMat("interplanetaryMagneticFieldValue.mat");
    }

}
