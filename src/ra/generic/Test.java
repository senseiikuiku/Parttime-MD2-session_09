package ra.generic;

public class Test {
    public static void main(String[] args) {
        DemoGeneric<String> demo = new DemoGeneric<>();
        demo.setElement("Duc");
        System.out.println(demo.getElement());
        DemoGeneric<Integer> demo2 = new DemoGeneric<>();
        demo2.setElement(3);
        System.out.println(demo2.getElement());

        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.setKey("Love");
        System.out.println(dictionary.getKey());
        dictionary.setValue("Duc");
        System.out.println(dictionary.getValue());

        GenericMethod genericMethod = new GenericMethod();
        Integer[] arr = {1,2,3,4,5};
        String[] arr2 = {"Duc","Thuy"};
        genericMethod.printElementOfArray(arr);
        genericMethod.printElementOfArray(arr2);
    }
}
