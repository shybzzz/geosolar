package geosolar.springmvc.controller;

import geosolar.domain.Dst;
import geosolar.springmvc.service.DemoService;
import geosolar.springmvc.service.DstService;
import geosolar.springmvc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/dst")
public class DstController {

    @Autowired
    private DstService dstService;
    @Autowired
    private FileService fileService;
    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    @ResponseBody
    public List<Dst> getDst() {
        return dstService.getDst();
    }

    @RequestMapping(value = "/mat")
    @ResponseBody
    public void getFile(HttpServletResponse response) {
        try {
            fileService.responseFile(response, dstService.getMatFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @RequestMapping("/hour/{hour}")
    @ResponseBody
    public List<Dst> getDstByHour(@PathVariable("hour") int hour) {
        return dstService.getDst();
    }

    @RequestMapping("/demoAdd/")
    @ResponseBody
    public List<Dst> demoAdd() {
        try {
            return demoService.demoAdd();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
