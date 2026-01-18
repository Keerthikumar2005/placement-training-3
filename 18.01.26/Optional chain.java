import java.util.*;
public class OptionalChain {
    public static void main(String[] args) {
        Optional<String> opt = Optional.of("hello");
        var result = opt.map(String::toUpperCase)
                       .orElse("DEFAULT");
        System.out.println(result);
    }
}
