package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*@RestController tell spring that this is a new Spring bean*//*
@RestController
public class SayHelloController {

    //    http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    public String hello() {
        return "Hello World!";
    }
}  */

/*This is another way to create Api*/
@Controller
public class SayHelloController {

    //    http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }

    //    http://localhost:8080/say-hello2
    @RequestMapping("say-hello2")
    @ResponseBody
    public StringBuffer sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<title>My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>My First HTML Page with Body</h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb;
    }
}
