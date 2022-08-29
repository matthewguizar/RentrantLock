import java.util.concurrent.locks.ReentrantLock;

public class Main {
    
    static int counter = 0;
    
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> task(lock));
        Thread thread2 = new Thread(() -> task(lock));

        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(counter);
    
    }
    
    public static void task(ReentrantLock lock) {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            counter++; 
            lock.unlock();
        }
    }
  
}
