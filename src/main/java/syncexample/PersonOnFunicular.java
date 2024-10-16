package syncexample;

import java.util.concurrent.CyclicBarrier;

public class PersonOnFunicular implements Runnable{

    private String name;

    private CyclicBarrier cyclicBarrier;

    public PersonOnFunicular(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println("->" + name + " waiting on platform");
        try {
            cyclicBarrier.await();
            System.out.println("!! " + name +" on the top");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
