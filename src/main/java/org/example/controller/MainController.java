package org.example.controller;

import org.example.service.SortService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    //Gradle + Intellij Community Edition 자료가 별로 없음.
    //War패키지를 배포하여 웹서버를 올리도록 아티팩트빌드 이런게 없음
    //Smart Tomcat 플러그인 설치해서 해결했는데,
    //Apache Tomcat 연동 시에, Smart Tomcat 설정 중 use classpath of module에서 프로젝트가 아니고 소스 내 패키지 선택해야
    //C:/Users/USER_NAME/.SmartTomcat/PROJECT_NAME/MODULE_NAME/conf/Catalina/localhost/ROOT.xml에서
    //Servlet 관련 리소스 체크가 가능해짐
    //war로 배포 안해도 해줌. 톰캣 서버의 클래스 경로를 자동으로 구성해주고, Webbapp 클래스 및 라이브러리 자동으로 로드해줌

    private final SortService sortService;

    public MainController(SortService sortService) {
        this.sortService = sortService;
    }
    //http://localhost:8080/?list=3,2,1
    @GetMapping("/")
    public String hello(@RequestParam List<String> list) {
        return sortService.doSort(list).toString();
    }
}
