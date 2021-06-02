package com.alfa.work3;

public class Printer implements Runnable{

    private Storage storage;
    private int count;

    public Printer(Storage storage, int count) {
        this.storage = storage;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (storage) {
            for (int i = 0; i < count; i++) {
                while (storage.isFlag()){
                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(storage.getNumber());
                storage.setFlag(true);
                storage.notify();
            }
        }
    }
}
