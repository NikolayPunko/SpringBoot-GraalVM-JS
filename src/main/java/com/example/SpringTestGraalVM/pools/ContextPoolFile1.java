package com.example.SpringTestGraalVM.pools;

import com.example.SpringTestGraalVM.model.ScriptContext;
import org.graalvm.polyglot.Engine;

import java.util.LinkedList;
import java.util.Queue;

public class ContextPoolFile1 {

    private static final Engine engine = Engine.create();
    private static final ContextPoolFile1 pool_manager = new ContextPoolFile1();
    private static final int POOL_SIZE = 5;
    private final Queue<ScriptContext> pool;

    private ContextPoolFile1() {
        pool = new LinkedList<>();
        for (int i = 0; i < POOL_SIZE; i++) pool.offer(new ScriptContext(i, engine));
    }

    public static ScriptContext borrowContext() throws InterruptedException {
//        System.out.println("Thread [" + Thread.currentThread().getName() + "] is waiting for borrow request");
        synchronized (pool_manager.pool) {
            while (pool_manager.pool.isEmpty()) pool_manager.pool.wait();
            return pool_manager.pool.poll();
        }
    }

    public static void returnContext(ScriptContext scriptContext) {
//        System.out.println("Thread [" + Thread.currentThread().getName() + "] is returning Context with ID [" + scriptContext.getId() + "]");
        synchronized (pool_manager.pool) {
            pool_manager.pool.offer(scriptContext);
            pool_manager.pool.notifyAll();
        }
    }

}

