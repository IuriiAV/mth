package syncexample;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(8);

        String[] person = {"Roman", "Elena", "Ivan", "Egor", "Anna", "Leo", "Bob", "Vika"};
        for (int i = 0; i < person.length; i++) {
            new Thread(new Passenger(person[i], countDownLatch)).start();
            Thread.sleep(1000);
        }
    }
}
