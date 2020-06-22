package com.aopdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {
//        Read value from the request
        String studentName = request.getParameter("studentName");
        studentName = studentName.toUpperCase();
//        Create the message
        String message = "Yo! " + studentName;

//        Add message to the model
        model.addAttribute("message", message);
        return "helloworld";
    }

    /**
     * Controller method that user @RequestParam annotation to automatically
     * get studentName parameters from request
     * @param studentName
     * @param model
     * @return
     */
    @RequestMapping("processFormVersionThree")
    public String letПGreetFriend(@RequestParam("studentName") String studentName, Model model) {
        studentName = studentName.toUpperCase();
//        Create the message
        String message = "Hello my friend " + studentName;

//        Add message to the model
        model.addAttribute("message", message);
        return "helloworld";
    }
}
