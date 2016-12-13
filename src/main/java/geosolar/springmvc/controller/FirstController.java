package geosolar.springmvc.controller;

import geosolar.springmvc.domain.Dst;
import geosolar.springmvc.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@Controller
public class FirstController {

    @Autowired
    private FirstService firstService;

    @RequestMapping("/dst/hour/{hour}")
    @ResponseBody
    public List<Dst> getDstByHour(@PathVariable("hour") int hour) {
        return this.firstService.getDstByHour(hour);
    }

}
