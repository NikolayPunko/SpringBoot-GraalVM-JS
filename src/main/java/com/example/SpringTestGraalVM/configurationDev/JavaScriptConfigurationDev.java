package com.example.SpringTestGraalVM.configurationDev;

import com.example.SpringTestGraalVM.model.ScriptContext;
import com.example.SpringTestGraalVM.service.JavaScriptService1;
import org.graalvm.polyglot.Source;

import java.io.File;
import java.io.IOException;


public class JavaScriptConfigurationDev {
    private static Source sourceFile1;

    static {
      assignSource();
    }

    public static void assignSource(){ //метод для обновления скрипта без перезагрузки приложения
        try {
            sourceFile1 = Source
                    .newBuilder("js", new File("C:\\Users\\User\\Desktop\\GraalVMProjects\\Spring-Test-GraalVM-JS\\src\\main\\resources\\static\\JavaScript\\TestJavaScript1.js"))
                    .build();
        } catch (IOException e) {
            System.out.println("script not found!");
            throw new RuntimeException(e);
        }
    }

    public static JavaScriptService1 getJavaScriptService1(ScriptContext scriptContext) {
        return scriptContext.getContext().eval(sourceFile1).getContext().getBindings("js")
                .as(JavaScriptService1.class);
    }

}
