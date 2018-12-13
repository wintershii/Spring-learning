package com.winter.controller;

import com.winter.domain.Person;
import com.winter.service.PersonService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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


    @RequestMapping(path = "/updatePersonInfo")
    public String updatePersonInfo(Integer id, Model model) {
        Person p = personService.get(id);
        model.addAttribute("p",p);
        return "update";
    }

    @RequestMapping(path = "/updatePersonList")
    public String updatePersonInfo(HttpServletRequest request, @Valid Person p,
                                   BindingResult bindingResult, Model model,
                                   @RequestParam("photo")MultipartFile photoFile) throws IOException {
        if (p.getId() == null) {
            p.setPhotoPath("/upload/index.png");
            personService.insert(p);
        } else {
            if (bindingResult.hasErrors()) {
                model.addAttribute("bindingResult",bindingResult);
                model.addAttribute("p",p);
                return "update";
            }
            String dir = request.getSession().getServletContext().getRealPath("/") + "/upload/";
            String fileName = photoFile.getOriginalFilename();
            String extName = fileName.substring(fileName.lastIndexOf("."));
            fileName = fileName.substring(0,fileName.lastIndexOf("."))  + System.nanoTime() + extName;

            FileUtils.writeByteArrayToFile(new File(dir + fileName), photoFile.getBytes());
            p.setPhotoPath("/upload/" + fileName);

            personService.update(p);
        }

        return "redirect:/user/all";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        personService.deleteById(id);
        return "redirect:/user/all";
    }

    @RequestMapping("/deleteMuch")
    public String deleteMuch(@RequestParam("id") Integer[] ids) {
        for (Integer delId : ids) {
            personService.deleteById(delId);
        }
        return "redirect:/user/all";
    }
}
