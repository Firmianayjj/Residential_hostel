package com.example.residentialhostel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.residentialhostel.mapper"})
public class ResidentialHostelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResidentialHostelApplication.class, args);
    }

}
