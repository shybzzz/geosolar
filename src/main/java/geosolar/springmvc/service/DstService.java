package geosolar.springmvc.service;

import geosolar.cassandra.repositories.DstCassandraRepository;
import geosolar.domain.Dst;
import geosolar.mat.repositories.DstMatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DstService {

    @Autowired
    private DstCassandraRepository dstCassandraRepository;
    @Autowired
    private DstMatRepository dstMatRepository;

    public List<Dst> getDst() {
        return dstCassandraRepository.getAll();
    }

    public File getMatFile() throws IOException {
        return dstMatRepository.getMatFile(getDst());
    }

}
