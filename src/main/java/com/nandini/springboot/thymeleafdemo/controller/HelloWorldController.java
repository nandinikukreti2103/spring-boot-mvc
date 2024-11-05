package com.nandini.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial  html form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form" ;
    }

    // need a controller method to process the html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "HelloNandini!" ;
    }

    //need a controller method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model){

        //read the request parameter from the html form
        String theName = request.getParameter("StudentName");

        // Check if the name is null or empty
        if (theName == null || theName.trim().isEmpty()) {
            model.addAttribute("message", "Please enter a valid name.");
            return "HelloNandini!"; // Ensure this view exists
        }


        //convert the data to all caps
        theName = theName.toUpperCase();

        //create message
        String result = "yo!  " + theName;

        //add message to the model
        model.addAttribute("message",result);
        return "HelloNandini!";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("StudentName") String theName, Model model){


        //convert the data to all caps
        theName = theName.toUpperCase();

        //create message
        String result = "Hello My Friend! " + theName;

        //add message to the model
        model.addAttribute("message",result);
        return "HelloNandini!";
    }


}
