package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

//

//    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    // /hello/form
  @RequestMapping(value="hello", method = RequestMethod.GET)
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' />" +
                "</br></br>" +
                "<select name = 'language' id='lang'>" +
                "<option value = 'Fi'>Finnish</option>" +
                "<option value = 'Ta'>Tagalog</option>" +
                "<option value = 'Po'>Polish</option>" +
                "<option value = 'Ir'>Irish</option>" +
                "<option value = 'Si'>Sinhala</option>" +
                "</select>" +
                "</br></br>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

//    Exercises
    @RequestMapping(method = RequestMethod.POST, value = "hello")
    public static String createMessage(@RequestParam String name, @RequestParam String language ) {
        if(name.equals("")){
            name = "World";
        }
        String greeting = "";

        if (language.equals("Fi")) {
            greeting =  "Moi, ";
        } else if (language.equals("Ta")) {
            greeting = "Kumusta, ";
        } else if (language.equals("Po")) {
            greeting = "Siema, ";
        } else if (language.equals( "Ir")) {
            greeting = "Dia duit, ";
        } else if (language.equals("Si")) {
            greeting = "Subha davasak, ";
        }

        return greeting + name + "!";
    }

}
