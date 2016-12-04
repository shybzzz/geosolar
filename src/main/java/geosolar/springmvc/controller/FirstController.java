package geosolar.springmvc.controller;

import geosolar.springmvc.domain.User;
import geosolar.springmvc.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * Created by osboxes on 11/09/16.
 */

@Controller
public class FirstController {

    @Autowired
    private FirstService firstService;

    @RequestMapping("/hallo")
    @ResponseBody
    public String sayHallo() {
        return "Hallo!";
    }

    @RequestMapping("/hallo/{name}")
    @ResponseBody
    public List<String> sayHallo(@PathVariable("name") String name) {
        return singletonList("Hallo " + name + "!");
    }

    @RequestMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return asList(new User("Rostyk"), new User("Ira"));
    }

    @RequestMapping("/my-users")
    @ResponseBody
    public List<User> getMyUsers() {
        return this.firstService.getMyUsers();
    }

    @RequestMapping("/cassandra-users")
    @ResponseBody
    public List<User> getCassandraUsers() {
        return this.firstService.getCassandraUsers();
    }

}
