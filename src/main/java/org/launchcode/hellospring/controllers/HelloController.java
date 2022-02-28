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

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //Exercises
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "language")
    public String createMessage(@RequestParam String name,String language ) {
        if (language == "Fin") {
            return "Moi, " + name + "!";
        } else if (language.equals("Tag")) {
            return "Kumusta " + name + "!";
        } else if (language.equals("Po")) {
            return "Siema " + name + "!";
        } else if (language.equals( "Ir")) {
            return "Dia duit " + name + "!";
        } else if (language.equals("Si")) {
            return "Subha davasak " + name + "!";
        } else {
            return "Hello!";
        }
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name = 'language' id='lang-select'>" +
                "<option selected=''>--Please choose an option--</option>" +
                "<option selected='Fin'>Finnish</option>" +
//       Moi (hi)
                "<option value = 'Tag'>Tagalog</option>" +
//        Kumusta (hi/hello)
                "<option value = 'Po'>Polish</option>" +
//        Siema (like 'howdy')
                "<option value ='Ir'>Irish</option> " +
//        Dia duit (hello)
                "<option value = 'Si'>Sinhala</option>" +
//        Subha davasak (hello)
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
