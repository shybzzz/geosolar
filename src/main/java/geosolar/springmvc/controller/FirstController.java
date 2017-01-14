package geosolar.springmvc.controller;

import geosolar.springmvc.domain.Dst;
import geosolar.springmvc.service.DstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class FirstController {

    @Autowired
    private DstService dstService;

    @RequestMapping("/dst/hour/{hour}")
    @ResponseBody
    public List<Dst> getDstByHour(@PathVariable("hour") int hour) {
        return this.dstService.getDstByHour(hour);
    }

    @RequestMapping(value = "/dst/mat", method = RequestMethod.GET)
    @ResponseBody
    public void getFile(HttpServletResponse response) throws IOException {
        File file = dstService.getMatFile(0);
        String fileName = file.getName();

        response.setContentType("application/octet-stream");
        response.setHeader(
                "Content-Disposition",
                "inline; filename=\"" + fileName + "\""
        );
        response.setContentLength((int) file.length());
        InputStream inputStream = new FileInputStream(fileName);
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
