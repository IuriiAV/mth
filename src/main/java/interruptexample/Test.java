package interruptexample;

import java.time.LocalTime;

public class Test implements Runnable {

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun) {
            for (int i = 0; i < 1000000l; i++) {
                int b = i;
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Call interrupt when thread run " + LocalTime.now());
                    isRun = false;
                    break;
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Call interrupt when thread sleep  " + LocalTime.now());
            }
        }
    }
}
