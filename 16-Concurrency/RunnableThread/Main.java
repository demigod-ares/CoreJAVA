package RunnableThread;

import static RunnableThread.ThreadColor.ANSI_GREEN;
import static RunnableThread.ThreadColor.ANSI_PURPLE;
import static RunnableThread.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread.");
        
        new Thread() { // quick use
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        Thread anotherThread = new AnotherThread(); // bad
        anotherThread.setName("Another Thread");
        anotherThread.start(); // why another thread is always getting executed in the end?

        Thread myRunnableThread = new Thread(new MyRunnable()); // good
        myRunnableThread.start();

        Thread myRunnableThreadOverride = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the overridden implementation of run() in class MyRunnable");
            }
        });
        myRunnableThreadOverride.start();

        System.out.println(ANSI_PURPLE+"Hello again from the main thread.");

    }
}
