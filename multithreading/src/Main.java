
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // First way of creating thread
        MyThread thread1 = new MyThread();

        // Second way of creating thread (more used, better way)
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
        // thread1.join();
        thread2.start();

        // System.out.println(1/0);


    }
}