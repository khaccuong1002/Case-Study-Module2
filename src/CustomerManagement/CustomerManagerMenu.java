package CustomerManagement;

import java.util.Scanner;

public class CustomerManagerMenu {
    public CustomerManagerMenu(){}

    CustomerManager customerManager = CustomerManager.getCustomerManager();

    Scanner sc = new Scanner(System.in);

    public void menu(){
        customerManager.readFromFile();
        int choice = 0;
        do {
            System.out.println("---------MENU KHÁCH HÀNG--------");
            System.out.println("1. Thêm thông tin khách hàng");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xoá thông tin khách hàng");
            System.out.println("4. Tìm tên khách hàng");
            System.out.println("5. Sắp xếp theo tên chữ cái A-Z");
            System.out.println("6. Sắp xếp theo tên chữ cái Z-A");
            System.out.println("7. Hiển thị danh dách khách hàng");
            System.out.println("8. Đọc file");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> addcustomer();
                case 2 -> fixcustomer();
                case 3 -> removecustomer();
                case 4 -> searchbyname();
                case 5 -> sortup();
                case 6 -> sortdescending();
                case 7 -> display();
                case 8 -> read();
                default -> System.out.println("Lựa chọn của bạn không tìm thấy");
            }
        } while (choice != 0);
    }

    private void read(){
        customerManager.readFromFile();
    }

    private void display(){
        customerManager.display();
    }

    private void sortdescending(){
        customerManager.sortDescending();
    }

    private void sortup(){
        customerManager.sortUp();
    }

    private void searchbyname(){
        System.out.println("Nhập tên khách hàng muốn tìm kiếm");
        String name = sc.nextLine();

        customerManager.searchByName(name);
    }

    private void removecustomer(){
        System.out.println("Nhập ID khách hàng bạn muốn xoá");
        String id = sc.nextLine();

        customerManager.removeCustomer(id);
    }

    private void fixcustomer(){
        System.out.println("Nhập ID khách hàng muốn sửa");
        String id = sc.nextLine();
        System.out.println("Nhập sửa tên khách hàng: ");
        String name = sc.nextLine();
        System.out.println("Nhập địa chỉ KH muốn thay đổi: ");
        String address = sc.nextLine();
        System.out.println("Nhập số điện thoại KH muốn thay đổi: ");
        String phonenumber = sc.nextLine();

        customerManager.fixCustomer(id, name, address, phonenumber);
    }

    private void addcustomer(){
        System.out.println("Nhập mã ID khách hàng: ");
        String id = sc.nextLine();
        while (customerManager.checkByID(id)){
            System.out.println("ID đã tồn tại. Vui lòng nhập lại!");
            id = sc.nextLine();
        }

        System.out.println("Nhập họ và tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();

        Customer customer = new Customer(id, name, address, phoneNumber);
        customerManager.addCustomer(customer);
    }
}
