package com.example.SpringTestGraalVM.configurationDev;

import com.example.SpringTestGraalVM.service.JavaScriptService1;
import com.example.SpringTestGraalVM.service.JavaScriptService2;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;

import java.io.File;
import java.io.IOException;


public class JavaScriptConfigurationDev {

    private final static Context context = Context
            .newBuilder("js")
            .allowHostAccess(HostAccess.ALL)
            .allowAllAccess(true)
            .build();
    public static JavaScriptService1 getJavaScriptBean1()  {
        File file = new File("C:\\Users\\User\\Desktop\\GraalVMProjects\\Spring-Test-GraalVM-JS\\src\\main\\resources\\static\\JavaScript\\TestJavaScript1.js");

        Source source = null;
        try {
            source = Source
                    .newBuilder("js", file)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        context.eval(source);

        return context
                .getBindings("js")
                .as(JavaScriptService1.class)
                ;
    }


    public static JavaScriptService2 getJavaScriptBean2() {
        File file = new File("C:\\Users\\User\\Desktop\\GraalVMProjects\\Spring-Test-GraalVM-JS\\src\\main\\resources\\static\\JavaScript\\TestJavaScript2.js");

        Source source = null;
        try {
            source = Source
                    .newBuilder("js", file)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        context.eval(source);

        return context
                .getBindings("js")
                .as(JavaScriptService2.class)
                ;
    }
}
