package com.group5.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index() {
        return "start";
    }

    @GetMapping("/hello")
    public ResponseEntity fetchgetHello() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/hello")
    public ResponseEntity fetchpostHello() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/hello")
    public ResponseEntity fetchputHello() {
        return new ResponseEntity(HttpStatus.OK);
    }

}
