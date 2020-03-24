package coursepackage.hello;
// this package has to be inside of the main package that has  the main methof

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*
    A spring controller
    --------------------
    - we have to annonate the class so that Spring Boot knows what's up
    The purpose of this controller is to recieve requests
    coming to endpoint /hello and
     */

    /*
    What does a class being a REST controller mean?
    ------------

    - It means you you can have methods in this class whihc map to the request made to that url
    - The method that gets invoked when the user requests that particular URL
     */


    // Write the methods here:
    @RequestMapping("/hello")   // ---> this annotation is how we map method to endpoint (GET method by default)
    public String sayHello(){
        return "Hello Ahmed! you made it";
    }

    // this method will be execyted when the user makes a request to /hello

    // I need to tell Spring Boot that this method needs to be called when this endpoint /hello is accessed




}
