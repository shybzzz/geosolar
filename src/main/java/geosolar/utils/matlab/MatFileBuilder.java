package geosolar.utils.matlab;

import com.jmatio.io.MatFileWriter;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MatFileBuilder {

    private ArrayList<MLArray> data = new ArrayList<>();

    public <T> MatFileBuilder addDoublesList(String listName, List<T> list, Function<T, double[]> convert) {
        double[][] doubles = new double[list.size()][];
        int i = 0;
        for (T listItem : list) {
            doubles[i] = convert.apply(listItem);
            i++;
        }
        data.add(new MLDouble(listName, doubles));
        return this;
    }

    public File buildMat(String fileName) throws IOException {
        File file = new File(fileName);
        MatFileWriter matFileWriter = new MatFileWriter();
        matFileWriter.write(file, data);
        return file;
    }

}
