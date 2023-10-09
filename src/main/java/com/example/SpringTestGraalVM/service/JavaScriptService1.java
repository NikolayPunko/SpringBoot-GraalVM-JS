package com.example.SpringTestGraalVM.service;

import com.example.SpringTestGraalVM.model.Person;
import org.graalvm.polyglot.Value;


public interface JavaScriptService1 {


    String testMethod_0(String str);

    int testMethod_1(int a, int b);

    String testMethod_2();

    String testMethod_3(Person person);

    Person testMethod_4(Person person);

}
