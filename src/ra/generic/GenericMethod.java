package ra.generic;

public class GenericMethod {
    public <E> void printElementOfArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }
}
