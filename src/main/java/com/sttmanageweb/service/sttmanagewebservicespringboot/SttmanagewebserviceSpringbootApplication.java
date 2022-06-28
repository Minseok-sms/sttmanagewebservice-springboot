package com.sttmanageweb.service.sttmanagewebservicespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.nio.charset.Charset;


@SpringBootApplication
@EnableJpaAuditing
public class SttmanagewebserviceSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SttmanagewebserviceSpringbootApplication.class, args);

    }


}
