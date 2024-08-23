package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;


public class Categories implements IShop<Categories> {
    private int catalogId;
    private String catalogName;
    private boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //    Phương thức có tồn tại chưa
    public boolean checkNameExist(String name, List<Categories> categoriesList) {
        for (Categories c : categoriesList) {
            if (c.getCatalogName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void inputData(Scanner sc, List<Categories> categoriesList) {
        System.out.print("Tên: ");
        String name;
        do {
            name = sc.nextLine().trim();
            if (checkNameExist(name, categoriesList) && !name.isEmpty()) {
                this.catalogName = name;
                break;
            } else {
                System.out.print("Tên danh mục đã tồn tại hoặc chưa nhập. Vui lòng nhập lại: ");
            }

        } while (true);
//        this.catalogName = sc.nextLine();
        System.out.print("Trạng thái: ");
        do {
            String statusInput = sc.nextLine().trim();
            if (statusInput.equalsIgnoreCase("true") || statusInput.equalsIgnoreCase("false")) {
                this.status = Boolean.parseBoolean(statusInput);
                break;
            } else {
                System.out.print("Trạng thái không hợp lệ. Vui lòng nhập lại (true/false): ");
            }

        } while (true);
    }

    @Override
    public void displayData() {
        System.out.println("Id: " + this.catalogId);
        System.out.println("Name: " + this.catalogName);
        System.out.println("Status: " + (this.status ? "Hoạt động" : "Không hoạt động"));
    }


}
