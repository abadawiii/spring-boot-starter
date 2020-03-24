package coursepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

    /*
    main method - main class
    in order to set up
     */

    public static void main(String[] args) {
        System.out.println("Hello, this is my first Spring Boot application...");
        System.out.println("---*---*---");
        SpringApplication.run(CourseApiApp.class, args);

    }
}
