package Challange1;

class OddThread extends Thread {
    @Override
    public void run() {

        for (int i = 1; i <= 10; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddThread interrupted!");
                // Thread.currentThread().interrupt(); // Reassert InterruptedException and not throw, loadingThread.isInterrupted() will always be true even when main thread inttrupts
                break;
            }
        }
    }
}

class EvenRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("EvenRunnable: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("EvenRunnable interrupted!");
                Thread.currentThread().interrupt(); // Reassert InterruptedException and not throw, loadingThread.isInterrupted() will always be true even when main thread inttrupts
                break;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        OddThread oddThread = new OddThread();

        Runnable evenRunnable = new EvenRunnable();
        // Runnable evenRunnable = () -> {
        //     for (int i = 2; i <= 10; i += 2) {
        //         System.out.println("EvenRunnable: " + i);
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             System.out.println("EvenRunnable interrupted!");
        //             Thread.currentThread().interrupt(); // Reassert InterruptedException and not throw, loadingThread.isInterrupted() will always be true even when main thread inttrupts
        //             break;
        //         }
        //     }
        // };
        Thread evenThread = new Thread(evenRunnable);
        oddThread.start();
        evenThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        oddThread.interrupt();
        System.out.println("Odd thread inttrupted : " + oddThread.isInterrupted());
    }
}
