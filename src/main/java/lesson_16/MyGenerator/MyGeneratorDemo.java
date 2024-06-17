package lesson_16.MyGenerator;

import java.util.ArrayList;
import java.util.List;

public class MyGeneratorDemo {

    private static final List<Integer> idList = new ArrayList<>();

    public static void main(String[] args) {



        Thread tg1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {

                idList.add(NotThreadSafeIdGenerator.nextId());

            }

        });
        Thread tg2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {

                idList.add(NotThreadSafeIdGenerator.nextId());

            }

        });
        Thread tg3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {

                idList.add(NotThreadSafeIdGenerator.nextId());

            }

        });


        tg1.start();
        tg2.start();
        tg3.start();

        try{
            tg1.join();
            tg2.join();
            tg3.join();
        } catch (InterruptedException e){
            System.out.println( "Thread was interrupted");
        }

        System.out.println(idList.size());




    }
}
