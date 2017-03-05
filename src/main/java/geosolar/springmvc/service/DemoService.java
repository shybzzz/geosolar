package geosolar.springmvc.service;

import geosolar.cassandra.repositories.DstCassandraRepository;
import geosolar.csv.repositories.DstCsvRepository;
import geosolar.domain.Dst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class DemoService {

    private static final String DEMO_DSTS_FILE_NAME = "/home/osboxes/IdeaProjects/geosolar/cql/assets/DST.csv";

    @Autowired
    private DstCassandraRepository dstCassandraRepository;
    @Autowired
    private DstCsvRepository dstCsvRepository;

    public List<Dst> demoAdd() throws FileNotFoundException {
        List<Dst> dsts = dstCsvRepository.getFromFile(DEMO_DSTS_FILE_NAME);
        dstCassandraRepository.add(dsts);
        return dsts;
    }

}


