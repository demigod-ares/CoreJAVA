package Threads;

import static Threads.Main.printThreadState;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        Thread another = Thread.currentThread();
        System.out.println(ThreadColor.RED.getCode() + "Hello from the another class thread: "  + another.getClass().getName());
        printThreadState(ThreadColor.RED.getCode(), another);

    }
}
