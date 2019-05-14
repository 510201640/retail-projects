package com.jiang.redis.concurrent;

import junit.framework.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author jiujiang
 * @date 2019/5/10
 */
public class BankTest {
    private CountDownLatch countDownLatch = new CountDownLatch(1000);
    private  AtomicInteger i =new AtomicInteger();
    private Lock lock = new ReentrantLock();
    @Test
    public void test() throws InterruptedException {
        for (int j = 0; j < 1000; j++) {
            IncreatThread t1 = new IncreatThread(countDownLatch);
            t1.start();
        }
        countDownLatch.await();
        System.err.println(i.get());
        Assert.assertEquals("预期结果是1000",1000,i.get());

    }
    class IncreatThread extends Thread{
        private  CountDownLatch countDownLatch;
        public IncreatThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            countDownLatch.countDown();
            add();
        }
    }
    public   void add(){
        i.incrementAndGet();
    }

    private AtomicInteger sum = new AtomicInteger();
    @Test
    public void test2() throws InterruptedException {
        for (int j = 0; j < 10; j++) {
            new Thread(()-> {
                for (int k = 0; k < 100; k++) {
                    sum.incrementAndGet();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.err.println(sum.get());



    }




}
