package geosolar.csv.generic;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;

@Component
public class CsvParser {

    public <T> List<T> getFromCsv(FileReader reader, Class<? extends T> type) {
        ColumnPositionMappingStrategy<T> columnPositionMappingStrategy = new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(type);
        CsvToBean<T> csvToBean = new CsvToBean<>();
        return csvToBean.parse(columnPositionMappingStrategy, new CSVReader(reader));
    }

}
