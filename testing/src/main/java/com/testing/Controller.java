package com.testing;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class Controller {

    @GetMapping("/test")
    public String test(){
        log.info("received message");
        return "Success";
    }
}
