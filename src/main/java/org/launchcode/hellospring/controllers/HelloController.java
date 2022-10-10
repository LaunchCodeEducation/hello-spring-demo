package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Handles request at path /hello
    @GetMapping("hello1")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

   // Handle request of the form /hello/name=LaunchCode
    //handles query parameters


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/launchCode

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
//
//    @GetMapping("venus")
//    @ResponseBody
//    public String venusSurface(@RequestParam String terrestrial) {
////        return terrestrial;
//        if (terrestrial.equals("true")) {
//            return "Venus is rocky.";
//        } else {
//            return "Venus is gaseous.";
//        }
//    }
    @GetMapping("venus/{orbiter}")
    @ResponseBody
    public String venusOrbiter(@PathVariable String orbiter) {
        return orbiter + " currently orbits Venus.";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
