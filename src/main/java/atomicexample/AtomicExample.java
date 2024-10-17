package atomicexample;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    //public static int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable counter = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                        //count++; // 1 . Read; 2. Increase; 3.Write
                    int sum = 500;

                    int i1 = count.incrementAndGet();
                    System.out.println("" + Thread.currentThread().getName() + " " + i1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread threadOne = new Thread(counter);
        threadOne.start();

        Thread threadTwo = new Thread(counter);
        threadTwo.start();

        Thread threadThree = new Thread(counter);
        threadThree.start();

//        threadTwo.join();
//        threadOne.join();
//        threadThree.join();

        System.out.println(count);
    }
}
