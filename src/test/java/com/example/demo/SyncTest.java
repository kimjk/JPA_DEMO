package com.example.demo;

import org.apache.commons.lang3.StringUtils;

/**
 * description
 *
 * @author : jkkim
 */
public class SyncTest {

    String str = "";

    public static void main(String[] args) {

        SyncTest syncTest = new SyncTest();

        System.out.println("start!!!!");

        new Thread(()->{
            for(int i=0; i<100; i++){
                syncTest.m1("T1");
            }
        }).start();

        new Thread(()->{
            for(int i=0; i<100; i++){
                syncTest.m1("T2");
            }
        }).start();

        System.out.println("end!!!!!");
    }

    public void m1(String param) {

        this.str = param;
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(!StringUtils.equals(str, param)){
            System.out.println("DIFF~~~~~~~~~~~~~~~");
        }

    }


}
