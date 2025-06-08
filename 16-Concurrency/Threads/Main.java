package Threads;

public class Main {

    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(ThreadColor.PURPLE.getCode() + "Hello from main thread: " + currentThread.getClass().getName());
        printThreadState(ThreadColor.PURPLE.getCode(), currentThread);
        
        Thread anotherThread = new AnotherThread();
        anotherThread.start(); // using start() and not run()

        new Thread() {
            public void run() {
                var anonymous = Thread.currentThread();
                System.out.println(ThreadColor.GREEN.getCode() + "Hello from the anonymous class thread: "  + anonymous.getClass().getName());
                printThreadState(ThreadColor.GREEN.getCode(), anonymous);
            }
        }.start();

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(ThreadColor.PURPLE.getCode() + "Hello again from main thread: " + currentThread.getClass().getName());
        printThreadState(ThreadColor.PURPLE.getCode(), currentThread);

    }

    // mixed color shows concurrent threads instead of parallel threads
    public static void printThreadState(String color, Thread thread) {
        System.out.println(color + "----------------------");
        System.out.println(color + "Thread.toString(): " + thread);
        System.out.println(color + "Thread.toString(): " + thread.toString());
        System.out.println(color + "Thread ID: " + thread.threadId());
        System.out.println(color + "Thread Name: " + thread.getName());
        System.out.println(color + "Thread ClassName: " + thread.getClass().getName());
        System.out.println(color + "Thread Priority: " + thread.getPriority());
        System.out.println(color + "Thread State: " + thread.getState());
        System.out.println(color + "Thread Group: " + thread.getThreadGroup());
        System.out.println(color + "Thread Is Alive: " + thread.isAlive());
        System.out.println(color + "----------------------");
    }
}
