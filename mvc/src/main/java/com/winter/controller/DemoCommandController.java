package com.winter.controller;

import com.winter.domain.Person;
import com.winter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class DemoCommandController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(path = "/handle")
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response,
                                  Person command) {

        System.out.println(command);
        return null;
    }

    @RequestMapping(path = "/all")
    public String findAll(Map<String,Object> model) {
        List<Person> list = personService.findAll();
        model.put("personList",list);
        return "personList";
    }

    @RequestMapping(path = "/createPersonInfo")
    public String toCreatePersonInfo() {
        return "personCreate";
    }

    @RequestMapping(path = "updatePersonList")
    public String updatePersonList(Person p) {
        personService.insert(p);
        return "redirect:/user/all";
    }
}
