package ra.entity;

import ra.IShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product implements IShop<Product> {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    private static List<Product> productList = new ArrayList<>();

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //    Phương thức đã tồn tại chưa
    public boolean checkIdExists(String id, List<Product> productList) {
        for (Product product : productList) {
            if (product.productId.equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNameExists(String name, List<Product> productList) {
        for (Product product : productList) {
            if (product.productName.equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void inputData(Scanner sc, List<Product> productList) {
        System.out.print("Nhập Id: ");
        String inputId;
        do {
            inputId = sc.nextLine().trim();
            if (inputId.matches("P\\w{4}") && checkIdExists(inputId, productList)) {
                this.productId = inputId;
                break;
            } else {
                System.out.print("Mã sản phẩm phải bắt đầu bằng 'P' và có độ dài 5 ký tự.\n" +
                        "Nhập lại Id: ");

            }
        } while (true);
        System.out.print("Nhập tên: ");
        do {
            String inputName = sc.nextLine().trim();
            if (checkNameExists(inputName, productList) && !inputName.isEmpty()) {
                this.productName = inputName;
                break;
            } else {
                System.out.print("Tên sản phẩm đã tồn lại hoặc Không được để trống. Vui lòng nhập lại: ");
            }
        } while (true);
        System.out.print("nhập Price: ");
        float inputPrice;
        do {
            String priceInput = sc.nextLine().trim();
            if (priceInput.matches("\\d+")) {
                inputPrice = Float.parseFloat(priceInput);
                if (inputPrice > 0) {
                    this.price = inputPrice;
                    break;
                }
            } else {
                System.out.print("Nhập số có giá trị lớn hơn 0: ");
            }
        } while (true);
        System.out.print("Nhập title: ");
        do {
            String titleInput = sc.nextLine().trim();
            if (!titleInput.isEmpty()) {
                this.title = titleInput;
                break;
            } else {
                System.out.print("Nhập lại title: ");
            }
        } while (true);
        System.out.print("Nhập Status: ");
        do {
            String statusInput = sc.nextLine().trim();
            if (statusInput.equalsIgnoreCase("true") || statusInput.equalsIgnoreCase("false")) {
                this.status = Boolean.parseBoolean(statusInput);
                break;
            } else {
                System.out.print("Chỉ được nhập true hoặc false: ");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + price);
        System.out.println("Product Title: " + title);
        System.out.println("Product Catalog ID: " + catalogId);
        System.out.println("Product Status: " + (status ? "Hoạt động" : "Không hoạt động"));
    }

}
