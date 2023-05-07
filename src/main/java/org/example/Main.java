package org.example;

import org.example.config.Config;
import org.example.service.SortService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //annotation 기반으로 동작하는 spring 컨테이너 생성

        SortService sortService = context.getBean(SortService.class);
        //new없이 구현체를 가져와서 main에서 서비스를 제공

        //Sort<String> sort = new JavaSort<>();

        System.out.println("[result] "+ sortService.doSort(Arrays.asList(args)));

    }
}