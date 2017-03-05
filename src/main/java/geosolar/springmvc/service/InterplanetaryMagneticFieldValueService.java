package geosolar.springmvc.service;

import geosolar.cassandra.repositories.InterplanetaryMagneticFieldValueCassandraRepository;
import geosolar.domain.InterplanetaryMagneticFieldValue;
import geosolar.mat.repositories.InterplanetaryMagneticFieldValueMatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class InterplanetaryMagneticFieldValueService {

    @Autowired
    private InterplanetaryMagneticFieldValueCassandraRepository interplanetaryMagneticFieldValueCassandraRepository;
    @Autowired
    private InterplanetaryMagneticFieldValueMatRepository interplanetaryMagneticFieldValueMatRepository;

    public List<InterplanetaryMagneticFieldValue> getInterplanetaryMagneticFieldValues() {
        return interplanetaryMagneticFieldValueCassandraRepository.getAll();
    }

    public File getMatFile() throws IOException {
        return interplanetaryMagneticFieldValueMatRepository.getMatFile(getInterplanetaryMagneticFieldValues());
    }

}
