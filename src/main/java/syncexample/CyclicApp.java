package syncexample;

import java.util.concurrent.CyclicBarrier;

public class CyclicApp {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Funicular());
        String[] person = {"Roman", "Elena", "Ivan", "Egor", "Anna", "Leo", "Bob", "Vika"};
        for (int i = 0; i < person.length; i++) {
            new Thread(new PersonOnFunicular(person[i], cyclicBarrier)).start();
            Thread.sleep(1000);
        }
    }
}
