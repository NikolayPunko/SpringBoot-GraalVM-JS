package com.example.SpringTestGraalVM.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.currentThread;

@Service
public class TestService {


    @Async
    public CompletableFuture<String> testWithAsync(String str) throws InterruptedException {
        System.out.println("Выполнение метода с @Async. Thread: " + currentThread().getName());
        Thread.sleep(2000);

        return CompletableFuture.completedFuture(str);
    }


    public String testWithoutAsync(String str) throws InterruptedException {
        System.out.println("Выполнение обычного метода. Thread: " + Thread.currentThread().getName());
        Thread.sleep(2000);

        return str;
    }

    @Async
    public void testWithAsyncVoid() throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("отработал метод с @Async void. Thread: " + currentThread().getName());
    }
}
