package syncexample;

import java.util.concurrent.Semaphore;

public class Person implements Runnable {

    private String name;

    private Semaphore semaphore;

    private boolean[] freeTables;

    public Person(String name, Semaphore semaphore, boolean[] freeTables) {
        this.name = name;
        this.semaphore = semaphore;
        this.freeTables = freeTables;
    }

    @Override
    public void run() {
        System.out.println(" -> " + name + " подошел в ресторан");
        //Поток либо пойдет за эту строчку кода или перейдет в состояние ожидания
        try {
            semaphore.acquire(); //5, 4 , 0 // if count == 0 then wait
            //Если счетчик семафора больше 0, то поток продолжает работать здесь
            int index = -1;
            synchronized (freeTables) {
                for (int i = 0; i < freeTables.length; i++) {
                    if (!freeTables[i]) {
                        freeTables[i] = true;
                        index = i;
                        System.out.println("!!! " + name + " занял столик  " + (i + 1));
                        break;
                    }
                }
            }
            Thread.sleep(10000);
            synchronized (freeTables) {
                freeTables[index] = false;
            }
            System.out.println("<- " + name + " покинул ресторан");
            semaphore.release(); // count ++; notifyAll()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
