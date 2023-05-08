package org.example.web;

import org.example.config.Config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        //톰캣에 애플리케이션을 올리게되면 onStartUp이 자동으로 인식되고 애플리케이션 컨텍스트이 생성될 것
        // dispatcherservlet을 초기화해주고 등록하는데, 서블릿 컨테이너에 의해 자동으로 감지됨
        // Main에서 해주던 것을 함.

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Config.class);

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/"); //root mapping.
    }
}