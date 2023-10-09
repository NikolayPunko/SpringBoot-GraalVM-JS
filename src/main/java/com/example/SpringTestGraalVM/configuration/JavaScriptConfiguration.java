package com.example.SpringTestGraalVM.configuration;

import com.example.SpringTestGraalVM.service.JavaScriptService1;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.io.File;
import java.io.IOException;

@Configuration
public class JavaScriptConfiguration {

    public final static Context context = Context
            .newBuilder("js")
            .allowHostAccess(HostAccess.ALL)
            .allowAllAccess(true)
            .build();


    @Bean
    public JavaScriptService1 getJavaScriptBean1() throws IOException {
        File file = new File(".\\src\\main\\resources\\static\\JavaScript\\TestJavaScript1.js");

        Source source = Source
                .newBuilder("js", file)
                .build();

        context.eval(source);


        return context
                .getBindings("js")
                .as(JavaScriptService1.class)
                ;
    }

}
