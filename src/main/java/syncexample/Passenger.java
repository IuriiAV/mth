package syncexample;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Passenger implements Runnable {

    private String name;

    private CountDownLatch countDownLatch;

    public Passenger(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("->" + name + " прибыл в аэропорт");
            Thread.sleep(100);
            System.out.println("!!" + name + " сдал багаж");
            Thread.sleep(500);
            System.out.println("!!" + name + " перекусил ");
            Thread.sleep(200);
            countDownLatch.countDown();

            countDownLatch.await(20, TimeUnit.SECONDS);
            System.out.println(" " + name + " полетел ");

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
