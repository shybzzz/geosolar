package geosolar.springmvc.controller;

import geosolar.domain.InterplanetaryMagneticFieldValue;
import geosolar.springmvc.service.InterplanetaryMagneticFieldValueService;
import geosolar.springmvc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("InterplanetaryMagneticFieldValue")
public class InterplanetaryMagneticFieldValueController {

    @Autowired
    private InterplanetaryMagneticFieldValueService service;
    @Autowired
    private FileService fileService;

    @RequestMapping("")
    @ResponseBody
    public List<InterplanetaryMagneticFieldValue> getDstByHour() {
        return service.getInterplanetaryMagneticFieldValues();
    }

    @RequestMapping(value = "/mat")
    @ResponseBody
    public void getFile(HttpServletResponse response) {
        try {
            fileService.responseFile(response, service.getMatFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
