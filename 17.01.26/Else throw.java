import java.util.*;
public class OptionalDemo {
    public static void main(String[] args) {
        var optional = Optional.of("Hello");
        var value = optional.orElseThrow();
        System.out.println(value);
        
        var empty = Optional.empty();
        try {
            empty.orElseThrow();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
        }
    }
}
