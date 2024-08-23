package ra.run;

import jdk.jfr.Category;
import ra.entity.Categories;
import ra.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static List<Categories> categoriesList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag1 = false;
        do {
            System.out.println("""
                    *************************SHOP MANAGEMENT***************
                    1. Quản lý danh mục sản phẩm
                    2. Quản lý sản phẩm
                    3. Thoát""");
            System.out.print("\nNhập lựa chọn: ");
            int choice1 = Integer.parseInt(sc.nextLine());
            switch (choice1) {
                case 1:
                    int categoryId = 1;
                    boolean flag2 = false;
                    do {
                        System.out.println("""
                                ***************** CATALOG MANAGEMENT**************
                                1. Thêm mới danh mục
                                2. Hiển thị thông tin các danh mục
                                3. Cập nhật tên danh mục theo mã danh mục
                                4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)
                                5. Thoát (Quay lại Shop Management)""");
                        System.out.print("\nNhập lựa chọn: ");
                        int choice2 = Integer.parseInt(sc.nextLine());
                        switch (choice2) {
                            case 1:
                                System.out.println("\nNhập thông tin danh mục sản phẩm");
                                System.out.print("Nhập số lượng thêm danh mục: ");
                                int n = Integer.parseInt(sc.nextLine());
                                for (int i = 0; i < n; i++) {
                                    Categories category = new Categories();
                                    category.setCatalogId(categoryId++);
                                    category.inputData(sc, categoriesList);
                                    categoriesList.add(category);
                                    System.out.println(i < n - 1 ? "----------" : "");
                                }
                                break;
                            case 2:
                                System.out.println("\n======Thông tin danh mục======");
                                for (int i = 0; i < categoriesList.size(); i++) {
                                    categoriesList.get(i).displayData();
                                    System.out.println(i < categoriesList.size() - 1 ? "----------" : "");
                                }
                                break;
                            case 3:
                                System.out.print("\nNhập Id danh mục cần cập nhật: ");
                                int id = Integer.parseInt(sc.nextLine());
                                System.out.print("Nhập tên mới: ");
                                boolean checkExists = false;
                                do {
                                    String catName = sc.nextLine().trim();
                                    for (Categories categories : categoriesList) {
                                        if (categories.getCatalogId() == id && updateNameCategoryExist(catName, categoriesList)) {
                                            categories.setCatalogName(catName);
                                            System.out.println("Cập nhật thành công");
                                            checkExists = true;
                                            break;
                                        } else {
                                            System.out.print("Đã tồn tại. Vui lòng nhập lại: ");
                                            break;
                                        }
                                    }
                                } while (!checkExists);
                                break;
                            case 4:

                                System.out.print("\nNhập Id danh mục cần xóa: ");
                                int deletedId = Integer.parseInt(sc.nextLine());
                                boolean deleted = false;
                                for (Categories categories : categoriesList) {
                                    if (categories.getCatalogId() == deletedId) {
//                                        Kiểm tra id có tồn tại không
                                        deleted = true;
//                                        Kiểm tra danh mục này có tồn tại sản phẩm chưa
                                        boolean hasProducts = false;
                                        for (Product product : productList) {
                                            if (product.getCatalogId() == deletedId) {
                                                hasProducts = true;
                                                break;
                                            }

                                        }
                                        if (!hasProducts) {
                                            categoriesList.remove(categories);
                                            System.out.println("Danh mục đã xóa thành công");

                                        } else {
                                            System.out.println("Không thể xóa vì danh mục có chứa sản phẩm hoặc id không tồn tại");
                                        }
                                        break;
                                    }
                                }
                                if (!deleted) {
                                    System.out.println("Id không tồn tại!");
                                }
                                break;
                            case 5:
                                flag2 = true;
                                System.out.println("\nĐã thoát");
                                break;
                            default:
                                System.out.println("\nNhập không đúng hợp lệ. Vui lòng nhập lại!");
                        }
                    } while (!flag2);
                    break;
                case 2:
                    boolean flag3 = false;
                    do {
                        System.out.println("""
                                ***************** PRODUCT MANAGEMENT**************
                                1. Thêm mới sản phẩm (Khi thêm cho phép chọn danh mục sản phẩm
                                mà sản phẩm thuộc về)
                                2. Hiển thị thông tin sản phẩm
                                3. Cập nhật giá sản phẩm theo mã sản phẩm
                                4. Xóa sản phẩm theo mã sản phẩm
                                5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần
                                6. Sắp xếp sản phẩm theo tên tăng dần
                                7. Thống kê số lượng sản phẩm theo danh mục sản phẩm
                                8. Tìm kiếm sản phẩm theo tên sản phẩm
                                9. Thoát (Quay lại Shop Management)""");
                        System.out.print("\nNhập lựa chọn: ");
                        int choice2 = Integer.parseInt(sc.nextLine());
                        switch (choice2) {
                            case 1:
                                if (categoriesList.isEmpty()) {
                                    System.out.println("\nChưa có danh mục nào!");
                                } else {

                                    System.out.print("\nNhập số lượng thêm sản phẩm: ");
                                    int n = Integer.parseInt(sc.nextLine());


                                    System.out.println("Chọn danh mục cho sản phẩm");
                                    for (int i = 0; i < categoriesList.size(); i++) {
                                        Categories categories = categoriesList.get(i);
                                        System.out.println((i + 1) + ". " + categories.getCatalogName());
                                    }

                                    System.out.print("Nhập lựa chọn danh mục: ");
//                                    Lấy id của danh mục để thêm sản phẩm
                                    int selectedCategoryId;
                                    do {
                                        int categoryChoice = Integer.parseInt(sc.nextLine());
                                        if (categoryChoice > 0 && categoryChoice <= categoriesList.size()) {
                                            selectedCategoryId = categoriesList.get(categoryChoice - 1).getCatalogId();
                                            break;
                                        } else {
                                            System.out.print("Nhập lại chọn danh mục: ");
                                        }

                                    } while (true);

                                    for (int i = 0; i < n; i++) {
                                        Product product = new Product();
                                        product.inputData(sc, productList);
                                        product.setCatalogId(selectedCategoryId);
                                        productList.add(product);
                                        System.out.println(i < productList.size() - 1 ? "----------" : "");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("\n=========Thông tin sản phẩm==========");
                                for (int i = 0; i < productList.size(); i++) {
                                    productList.get(i).displayData();
                                    System.out.println(i < productList.size() - 1 ? "----------" : "");
                                }
                                break;
                            case 3:
                                System.out.print("\nNhập Id sản phẩm cần cập nhật: ");
                                String id = sc.nextLine();
                                System.out.print("Nhập giá cần cập nhật: ");
                                float price = Float.parseFloat(sc.nextLine());
                                boolean check = false;
                                for (Product product : productList) {
                                    if (product.getProductId().equals(id)) {
                                        product.setPrice(price);
                                        System.out.println("Cập nhật thành công");
                                        check = true;
                                        break;
                                    }
                                }
                                if (!check) {
                                    System.out.println("Không có Id sản phẩm như vậy");
                                }
                                break;
                            case 4:
                                System.out.print("\nNhập mã sản phẩm cần xóa: ");
                                String proID = sc.nextLine();
                                boolean check2 = false;

                                for (Product product : productList) {
                                    if (product.getProductId().equals(proID)) {
                                        productList.remove(product);
                                        System.out.println("Đã xóa thành công");
                                        check2 = true;
                                        break;
                                    }
                                }
                                if (!check2) {
                                    System.out.println("Không Id nào như vậy");
                                }
                                break;
                            case 5:
                                System.out.println("\nSản phầm đã dược sắp xếp!");
                                productList.sort(new Comparator<Product>() {
                                    @Override
                                    public int compare(Product o1, Product o2) {
                                        return Float.compare(o1.getPrice(), o2.getPrice());
                                    }
                                });
                                for (int i = 0; i < productList.size(); i++) {
                                    productList.get(i).displayData();
                                    System.out.println(i < productList.size() - 1 ? "----------" : "");
                                }
                                break;
                            case 6:
                                System.out.println("\nSản phẩm đã được sắp xếp");
                                productList.sort(new Comparator<Product>() {
                                    @Override
                                    public int compare(Product o1, Product o2) {
                                        return o1.getProductName().compareTo(o2.getProductName());
                                    }
                                });
                                for (int i = 0; i < productList.size(); i++) {
                                    productList.get(i).displayData();
                                    System.out.println(i < productList.size() - 1 ? "----------" : "");
                                }
                                break;
                            case 7:
                                System.out.println("\nBảng thống kê!");
                                for (Categories categories : categoriesList) {
                                    int count = 0;
                                    for (Product product : productList) {
                                        if (product.getCatalogId() == categories.getCatalogId()) {
                                            count++;
                                        }
                                    }
                                    System.out.println("Danh mục " + categories.getCatalogName() + " có " + count + " sản phẩm");

                                }
                                break;
                            case 8:
                                System.out.print("\nNhập sản phẩm cần tìm: ");
                                String name = sc.nextLine();
                                for (int i = 0; i < productList.size(); i++) {
                                    if (productList.get(i).getProductName().contains(name)) {
                                        productList.get(i).displayData();
                                        System.out.println(i < productList.size() - 1 ? "----------" : "");
                                    }
                                }
                                break;
                            case 9:
                                flag3 = true;
                                System.out.println("\nĐã thoát");
                                break;
                            default:
                                System.out.println("\nNhập không hợp lệ. Vui lòng nhập lại!");
                        }
                    } while (!flag3);
                    break;
                case 3:
                    flag1 = true;
                    System.out.println("\nĐã thoát chương trình");
                    break;
                default:
                    System.out.println("\nNhập không hợp lệ. Vui lòng nhập lại!");
            }
        } while (!flag1);
    }
//    Phương thức kiểm tra tên có tồn tại chưa trong danh mục
    public static boolean updateNameCategoryExist(String name, List<Categories> categoriesList) {
        for (Categories categories : categoriesList) {
            if (categories.getCatalogName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
