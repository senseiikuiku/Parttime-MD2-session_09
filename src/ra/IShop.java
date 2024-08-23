package ra;

import ra.entity.Categories;

import java.util.List;
import java.util.Scanner;

public interface IShop<T> {
    public void inputData(Scanner sc, List<T> list);

    public void displayData();
}
