package com.youwiz.springbatchn1;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Springbatchn1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbatchn1Application.class, args);
    }

}
