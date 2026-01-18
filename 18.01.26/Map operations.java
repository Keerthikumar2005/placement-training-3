import java.util.*;
public class MapOps {
    public static void main(String[] args) {
        var map = Map.of(
            "Apple", 10,
            "Banana", 20,
            "Cherry", 30
        );
        
        System.out.println("Map: " + map);
        System.out.println("Apple price: " + map.get("Apple"));
    }
}
