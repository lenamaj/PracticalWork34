package com.alfa.work2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Runner {

    public void run(){

      int [] arr = createArray();
        System.out.println(Arrays.toString(arr));
        int start = 5;
        int end =15;


     /*   new Thread(() ->
                System.out.println( Arrays.stream(arr)
                        .limit(end)
                        .skip(start)
                        .sum())).start();*/

        //Callable<Integer> tr = () -> Arrays.stream(arr).limit(end).skip(start).sum();
        Future<Integer> res = new FutureTask<>(() -> Arrays.stream(arr).limit(end).skip(start).sum());
        new Thread((FutureTask)res).start();
        try {
            System.out.println("Sum = "+res.get());
        } catch (InterruptedException e) { e.printStackTrace(); }
        catch (ExecutionException e) { e.printStackTrace(); }
    }

    public int[] createArray(){
       /* Random random = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] =*/
            return new Random().ints(25, 0, 100).toArray();

        }
    }

