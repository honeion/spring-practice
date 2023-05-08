package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//spring 전용 configuration 클래스가 되었고, application context가 뜰 때, 해당 config 설정 스프링에서 확인
@EnableWebMvc
@ComponentScan("org.example") //org.example 하위의 빈들을 전부 스캔
@Configuration
public class Config {
}
