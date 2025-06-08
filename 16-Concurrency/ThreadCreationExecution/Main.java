package ThreadCreationExecution;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        try {
                System.out.println("Main thread sleeping.");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main thread continue. And other threads can only be executed after that.");

        // 1. Class
        CustomThread customThread = new CustomThread();
        customThread.start();

        // 2. Interface
        Runnable myRunnable = () -> {
            for (int i = 1; i <= 8; i++) {
                System.out.println("Implemented Runnable interface and executing. Iteration: " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                 } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();

        // 3. Main thread
        for (int i = 1; i <= 3; i++) {
            System.out.println("Main thread executing. Iteration: " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // concurrent threads above

        // parallel threads below

        customThread.run();
        myThread.run();
    }
}
