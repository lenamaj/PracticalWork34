package com.alfa.work3;

public class Counter implements Runnable{
 private Storage storage;
 private int count;

    public Counter(Storage storage, int count) {
        this.storage = storage;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (storage) {
            for (int i = 0; i < count; i++) {
                while (!storage.isFlag()){
                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                storage.setNumber(storage.getNumber() + 1);
                storage.setFlag(false);
                storage.notify();
            }
        }
    }
}
