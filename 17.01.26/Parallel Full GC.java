import java.util.*;
import java.util.concurrent.*;

public class ParallelGCDemo {
    private static final int DATA_SIZE = 10_000_000;
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting memory-intensive operations...");
        
        
        for (int i = 0; i < 100; i++) {
            var largeList = new ArrayList<Integer>();
            for (int j = 0; j < DATA_SIZE / 100; j++) {
                largeList.add(j);
            }
            
           
            var sum = largeList.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
                
            System.out.printf("Iteration %d: Processed %d items, sum = %d%n", 
                i + 1, largeList.size(), sum);
