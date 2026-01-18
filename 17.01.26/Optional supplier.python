import java.util.*;
public class OptionalThrow {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        
        try {
            String value = empty.orElseThrow(() -> 
                new RuntimeException("Value not found"));
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
