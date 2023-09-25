package com.example.SpringTestGraalVM.controller;
import com.example.SpringTestGraalVM.configuration.JavaScriptConfiguration;
import com.example.SpringTestGraalVM.model.Person;
import com.example.SpringTestGraalVM.service.JavaScriptService1;
import com.example.SpringTestGraalVM.service.JavaScriptService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringTestGraalVM.configurationDev.JavaScriptConfigurationDev;

import java.io.IOException;


@RestController
@RequestMapping("/js")
public class TestController {

    @Autowired
    DefaultListableBeanFactory beanFactory;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    JavaScriptConfiguration javaScriptConfiguration;

    private final JavaScriptService1 javaScriptService1;

    private final JavaScriptService2 javaScriptService2;

    public TestController(JavaScriptService1 javaScriptService1, JavaScriptService2 javaScriptService2) {
        this.javaScriptService1 = javaScriptService1;
        this.javaScriptService2 = javaScriptService2;
    }

    @GetMapping("/reload")
    public void testMethod0() throws IOException {
//        beanFactory.destroySingleton("getJavaScriptBean");

    }

    @GetMapping("/method1")
    public int testMethod1() {
//        return javaScriptService1.testMethod_1(5, 10); // через @Bean
        return JavaScriptConfigurationDev.getJavaScriptBean1().testMethod_1(5, 10); //через обычный Java класс
    }


    @GetMapping("/method2")
    public String testMethod2() throws IOException {
//        return javaScriptService.testMethod_2(); // через @Bean
        return JavaScriptConfigurationDev.getJavaScriptBean1().testMethod_2(); //через обычный Java класс
    }

    @GetMapping("/method3")
    public String testMethod3() {
//        return javaScriptService1.testMethod_3(new Person("Ivan",35)); // через @Bean
        return JavaScriptConfigurationDev.getJavaScriptBean1().testMethod_3(new Person("Ivan",35)); //через обычный Java класс
    }

    @GetMapping("/method4")
    public Person testMethod4() {
//        return javaScriptService1.testMethod_4(new Person("Ivan",35)); // через @Bean
        return JavaScriptConfigurationDev.getJavaScriptBean1().testMethod_4(new Person("Ivan",35));  //через обычный Java класс
    }


    // второй скрипт

    @GetMapping("/method5")
    public String testMethod5() {
//        return javaScriptService2.testMethod_1();  // через @Bean
        return JavaScriptConfigurationDev.getJavaScriptBean2().testMethod_1(); //через обычный Java класс
    }



}
