package geosolar.csv.repositories;

import geosolar.csv.generic.CsvParser;
import geosolar.domain.Dst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
public class DstCsvRepository {

    @Autowired
    private CsvParser csvParser;

    public List<Dst> getFromFile(String fileName) throws FileNotFoundException {
        FileReader reader = new FileReader(fileName);
        List<Dst> dsts = csvParser.getFromCsv(reader, Dst.class);
        for (Dst dst : dsts) {
            dst.setId(randomUUID());
        }
        return dsts;
    }

}
