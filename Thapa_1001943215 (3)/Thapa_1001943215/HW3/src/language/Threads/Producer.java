package language.Threads;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
    private List<String> buffer;
    public ReentrantLock bufferLock;

    public Producer(List<String> buffer,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    public void run() {
        String starStringName[] = {"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island","Tennessee",
                "Texas","Utah", "Vermont","Virginia","Washington","WestVirginia","Wisconsin","Wyoming"};
        Random random = new Random();
        for (String starName : starStringName) {
            synchronized (buffer) {
                buffer.add(starName);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() +  " Adding..." + reverse(starName));
        }
        System.out.println(Thread.currentThread().getName() + " Adding..." + reverse(Main.EOF));
        synchronized (buffer) {
            buffer.add(Main.EOF);
        }
    }
    public static String reverse(String set){
        return new StringBuffer(set).reverse().toString();
    }
}
