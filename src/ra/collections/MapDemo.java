package ra.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");

        System.out.println(map.get(1));
        map.remove(2);
        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        };
    }
}
