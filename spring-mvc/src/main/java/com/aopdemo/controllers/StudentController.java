package com.aopdemo.controllers;

import com.aopdemo.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("theCountryOptions", countryOptions);
        return "student-form";
    }

    /**
     *
     * @param theStudent - the POJO that already contains data from the form.
     *                   this object was added in method #showForm in model.
     * @return another view
     */
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        return "student-confirmation";
    }
}
