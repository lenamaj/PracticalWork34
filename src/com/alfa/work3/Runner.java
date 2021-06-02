package com.alfa.work3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class Runner {
    public void run(){
        Storage storage = new Storage();

/*        new Thread(new Printer(storage, 10)).start();
        new Thread(new Counter(storage, 10)).start();*/


       /* int count = 10;
        Semaphore semaphore = new Semaphore(0, true);
        new Thread(() -> {
            for (int i = 0; i < count; i++) {

                storage.setNumber(storage.getNumber() + 1);
                semaphore.release();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ).start();

        new Thread(() ->{
            for (int i = 0; i < count; i++) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(storage.getNumber());
            }
        } ).start();*/

        int count = 10;
        SynchronousQueue<Storage> queue = new SynchronousQueue<>();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {

                storage.setNumber(storage.getNumber() + 1);
                try {
                    queue.put(storage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } ).start();

        new Thread(() ->{
            for (int i = 0; i < count; i++) {
                try {
                    System.out.println(queue.take().getNumber());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ).start();


    }
}
