package interruptexample;

public class App {

    public static void main(String[] args) {
        Thread thread = new Thread(new Test());
        thread.start();
        thread.stop();

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             thread.interrupt();

        }
    }
}
