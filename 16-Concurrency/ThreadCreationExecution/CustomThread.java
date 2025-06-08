package ThreadCreationExecution;

public class CustomThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread Class extended and executed. Iteration: " + i);
            try {
                Thread.sleep(500);  // Adding a 1-second delay between each count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
