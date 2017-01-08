package geosolar.springmvc.controller;

import com.jmatio.io.MatFileWriter;
import com.jmatio.types.MLArray;
import com.jmatio.types.MLDouble;
import geosolar.springmvc.domain.Dst;
import geosolar.springmvc.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {

    @Autowired
    private FirstService firstService;

    @RequestMapping("/dst/hour/{hour}")
    @ResponseBody
    public List<Dst> getDstByHour(@PathVariable("hour") int hour) {
        return this.firstService.getDstByHour(hour);
    }

    @RequestMapping(value = "/dst/mat", method = RequestMethod.GET)
    @ResponseBody
    public void getFile(HttpServletResponse response) throws IOException {
        double[][] d = new double[1][];
        d[0] = new double[1];
        d[0][0] = 1;
        MLDouble d1 = new MLDouble("d", d);

        ArrayList<MLArray> data = new ArrayList<>();
        data.add(d1);
        String fileName = "hallo.mat";
        new MatFileWriter(fileName, data);
        InputStream inputStream = new FileInputStream(fileName);
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
