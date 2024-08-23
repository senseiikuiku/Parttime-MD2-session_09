package ra.generic;

import java.util.List;

public interface IPerson<T> {
    List<T> getAll();

    boolean add(T t);

}
