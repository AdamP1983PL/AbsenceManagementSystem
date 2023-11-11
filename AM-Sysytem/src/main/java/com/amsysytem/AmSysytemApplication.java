package com.amsysytem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:db.properties")
@SpringBootApplication
public class AmSysytemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmSysytemApplication.class, args);
    }

}
