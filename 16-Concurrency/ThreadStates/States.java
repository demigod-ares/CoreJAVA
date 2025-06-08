package ThreadStates;

public class States {

    public static void main(String[] args) {
        String mainThread = Thread.currentThread().getName();
        System.out.println(mainThread + " : Main thread running");
        System.out.println(mainThread + " : " + Thread.currentThread().getState());
        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread loadingThread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 steps to run.");
            System.out.println(tname + " : " + Thread.currentThread().getState());
            for (int i = 0; i < 10; i++) {
                System.out.println("Loading ... " + (i+1));
                try {
                    Thread.sleep(500);
                    System.out.println(tname + " : " + Thread.currentThread().getState());                    
                } catch (InterruptedException e) {
                    System.out.println("Whoops!! " + tname + " interrupted.");
                    System.out.println(tname + " state on InterruptedException : " + Thread.currentThread().getState());
                    Thread.currentThread().interrupt(); // Reassert InterruptedException and not throw, otherwise loadingThread.isInterrupted() will always be false even when threadMonitor inttrupts
                    System.out.println(tname + " state on Interrupt execution : " + Thread.currentThread().getState());
                    return;
                }
            }
            System.out.println("\n" + tname + " completed.");
        },"LoadingThread");

        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should inttrupt loadingThread in 2 sec.");
            while (loadingThread.isAlive()) {
                try {
                    System.out.println(tname + " : " + Thread.currentThread().getState());
                    System.out.println(loadingThread.getName() + " monitor with current state : " + loadingThread.getState());
                    Thread.sleep(1000);
                    if (System.currentTimeMillis() - now > 8000) { // 2000 ms loadingThread will be inttrupted, 8000 ms loadingThread will not be inttrupted
                        System.out.println(loadingThread.getName() + " with current state : " + loadingThread.getState() + " will be inttrupted !!!\n");
                        loadingThread.interrupt();
                        System.out.println(tname + " Inttrupt Action : " + Thread.currentThread().getState());
                    }
                } catch (InterruptedException e) {
                    System.out.println(tname + " Exception : " + Thread.currentThread().getState());
                    System.out.println(loadingThread.getName() + " monitor with current state : " + loadingThread.getState());
                    e.printStackTrace();
                }
            }
        }, "MonitorThread");

        System.out.println(loadingThread.getName() + " starting");
        loadingThread.start();
        System.out.println(threadMonitor.getName() + " starting");
        threadMonitor.start();

        // ========================================================= join ======================================================
        try {
            System.out.println(loadingThread.getName() + " join will be performed");
            loadingThread.join(); // if join is not performed with main thread, then below code will not wait for loadingThread
            System.out.println(loadingThread.getName() + " joined");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        Thread installThread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 3 steps to run.");
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(tname + " : " + Thread.currentThread().getState());
                    Thread.sleep(250);
                    System.out.println("Installation Step " + (i + 1) + " is completed.");
                }
            } catch (InterruptedException e) {
                System.out.println(tname + " : " + Thread.currentThread().getState());
                e.printStackTrace();
            }
        }, "InstallThread");

        if (!loadingThread.isInterrupted()) {
            System.out.println(installThread.getName() + " starting at this point !!!");
            System.out.println(loadingThread.getName() + " with current state : " + loadingThread.getState());
            System.out.println(threadMonitor.getName() + " with current state : " + threadMonitor.getState());
            installThread.start();
        } else {
            System.out.println("Warning !!! Previous loadingThread was interrupted, " + installThread.getName() + " can't run !!!");
        }
    }
}
