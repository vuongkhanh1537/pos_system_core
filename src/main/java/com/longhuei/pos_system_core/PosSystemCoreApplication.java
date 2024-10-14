package com.longhuei.pos_system_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class PosSystemCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosSystemCoreApplication.class, args);
    }

}
