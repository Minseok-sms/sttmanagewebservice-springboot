package com.sttmanageweb.service.sttmanagewebservicespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SttmanagewebserviceSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SttmanagewebserviceSpringbootApplication.class, args);

    }

}
