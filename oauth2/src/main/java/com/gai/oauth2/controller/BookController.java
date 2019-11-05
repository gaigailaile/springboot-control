package com.gai.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Created by gaigaicoming on 2019/10/21.
*/
@RestController
//@RequestMapping("book")
public class BookController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping(value = "/admin/hello")
    public String admin(){
        return "/admin/hello";
    }

    @GetMapping(value = "/user/hello")
    public String user(){
        return "/user/hello";
    }

    @GetMapping(value = "/db/hello")
    public String dba(){
        return "/db/hello";
    }

}
