package ra.collections;

import java.util.ArrayList;
import java.util.List;

public class ListArrayList {
    public static void main(String[] args) {

        List<Cat> listcat = new ArrayList<>();
        Cat cat1 = new Cat("Thuy",20);
        Cat cat2 = new Cat("Thuy2",20);
        listcat.add(cat1);
        listcat.add(cat2);
        System.out.println(listcat.size());
        System.out.println(listcat.contains(cat1));
        listcat.toArray();
    }
}
