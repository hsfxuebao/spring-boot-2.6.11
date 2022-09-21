package smoketest.tomcat.demo.start.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoHelloController {

    @GetMapping("/hello66")
    public String hello(){

        return "66666666~~~~~";
    }
}
