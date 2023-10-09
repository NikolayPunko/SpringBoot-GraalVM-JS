package com.example.SpringTestGraalVM.controller;

import com.example.SpringTestGraalVM.configuration.JavaScriptConfiguration;
import com.example.SpringTestGraalVM.model.Person;
import com.example.SpringTestGraalVM.model.ScriptContext;
import com.example.SpringTestGraalVM.pools.ContextPoolFile1;
import com.example.SpringTestGraalVM.service.JavaScriptService1;
import com.example.SpringTestGraalVM.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import com.example.SpringTestGraalVM.configurationDev.JavaScriptConfigurationDev;

import static java.lang.Thread.sleep;


@RestController
@RequestMapping("/js")
public class TestController {

    @Autowired
    JavaScriptConfiguration javaScriptConfiguration;

    @Autowired
    TestService testService;

    public TestController() {

    }

    @GetMapping("/reset-source-script") //обновить скрипты
    public void testMethod11() {
        JavaScriptConfigurationDev.assignSource();
    }


    //    @CrossOrigin(origins = "*")
    @GetMapping("/method1")
    public int testMethod1() throws InterruptedException {
//        synchronized (JavaScriptConfiguration.context) {
//            return javaScriptService1.testMethod_1(5, 10);
//        }

        ScriptContext context = ContextPoolFile1.borrowContext();// исп. пул контекстов
        int result = JavaScriptConfigurationDev.getJavaScriptService1(context).testMethod_1(5, 10);
        ContextPoolFile1.returnContext(context);
        return result;
    }


    @GetMapping("/method2")
    public String testMethod2() throws InterruptedException {

//        synchronized (JavaScriptConfiguration.context) { // если использовать один контекст
//           return str = javaScriptService1.testMethod_2();
//        }

        ScriptContext context = ContextPoolFile1.borrowContext();// исп. пул контекстов
        String str = JavaScriptConfigurationDev.getJavaScriptService1(context).testMethod_2();
        ContextPoolFile1.returnContext(context);
        return str;
    }


    @GetMapping("/method3")
    public String testMethod3() throws InterruptedException {

//        synchronized (JavaScriptConfiguration.context) {
//            return javaScriptService1.testMethod_3(new Person("Ivan", 35));
//        }

        ScriptContext context = ContextPoolFile1.borrowContext();// исп. пул контекстов
        String str = JavaScriptConfigurationDev.getJavaScriptService1(context).testMethod_3(new Person("Ivan", 35));
        ContextPoolFile1.returnContext(context);
        return str;
    }

    @GetMapping("/method4")
    public Person testMethod4() throws InterruptedException {

//        synchronized (JavaScriptConfiguration.context) {
//            return javaScriptService1.testMethod_4(new Person("Ivan", 35));
//        }

        ScriptContext context = ContextPoolFile1.borrowContext();// исп. пул контекстов
        Person person = JavaScriptConfigurationDev.getJavaScriptService1(context).testMethod_4(new Person("Ivan", 35));
        ContextPoolFile1.returnContext(context);
        return person;
    }





    //    @GetMapping("/test{id}")
//    public String testMethod0(@PathVariable("id") int id) throws InterruptedException {
//        System.out.println("request id: "+ id +"; Стартовал; Thread: " + currentThread().getName());
//        Thread.sleep(x);
//        System.out.println("request id: "+ id +"; Продолжил; Thread: " + currentThread().getName());
////        String result = testService.testWithAsync("request id: "+ id +"; Закончил; Thread: " + currentThread().getName()).join();
//        String result = testService.testWithoutAsync("request id: "+ id +"; Закончил; Thread: " + currentThread().getName());
//        testService.testWithAsyncVoid();
//        System.out.println(result);
//        return result;
//    }
}
