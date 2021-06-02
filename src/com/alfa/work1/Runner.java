package com.alfa.work1;

public class Runner {

    public void run(){

        new MyTimeBomb_1().start();

        new Thread(() -> {
            for (int i = 10; i > 0 ; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Booom");
        }).start();


    }
}
