import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    
    static int counter = 0;
    
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> task(lock, latch));
        Thread thread2 = new Thread(() -> task(lock, latch));

        thread1.start();
        thread2.start();
        
        try {
           latch.await();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(counter);
    
    }
    
    public static void task(ReentrantLock lock, CountDownLatch latch) {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            counter++; 
            lock.unlock();
        }
        latch.countDown();
    }
  
}
