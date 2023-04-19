package com.jiayang.tliaswebmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TliasWebmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebmanagementApplication.class, args);
    }

}
