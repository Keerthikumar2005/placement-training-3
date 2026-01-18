import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ThreadLocalHandshakeDemo {
    private static final int THREAD_COUNT = 5;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private static volatile boolean stopRequested = false;
    
    static class Worker implements Runnable {
        private final int id;
        private long localCounter = 0;
        
        public Worker(int id) {
            this.id = id;
        }
        
        @Override
        public void run() {
            System.out.printf("Worker %d started%n", id);
            
            while (!stopRequested) {
                
                for (int i = 0; i < 1000; i++) {
                    localCounter++;
                    Math.sqrt(localCounter); // Some computation
                }
                
                counter.incrementAndGet();
                 if (localCounter % 10000 == 0) {
                    System.out.printf("Worker %d: local=%d, global=%d%n", 
                        id, localCounter, counter.get());
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
            System.out.printf("Worker %d finished. Total iterations: %d%n", 
                id, localCounter);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread-Local Handshake Demo");
        System.out.println("============================");
        
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(new Worker(i));
        }
        Thread.sleep(3000);
        System.out.println("\nRequesting stop...");
        stopRequested = true;
        
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        
        System.out.println("\nFinal counter value: " + counter.get());
        System.out.println("All threads stopped gracefully.");
    }
}
