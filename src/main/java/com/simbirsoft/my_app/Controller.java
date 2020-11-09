package com.simbirsoft.my_app;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hey")
    public ResponseEntity<String> sayHey(){
        return new ResponseEntity<String>("Hi", HttpStatus.OK);
    }

    @PostMapping("/hey")
    public ResponseEntity<String> sayHey1(){
        return new ResponseEntity<String>("Hi1", HttpStatus.OK);
    }
}
