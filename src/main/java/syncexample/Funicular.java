package syncexample;

public class Funicular implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Took people and going to the top");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
