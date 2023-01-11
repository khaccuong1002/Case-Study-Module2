
import BookManagement.BookManagementMenu;
import CustomerManagement.CustomerManagerMenu;
import OrdersManager.InvoiceManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookManagementMenu bookManagementMenu = new BookManagementMenu();
        CustomerManagerMenu customerManagerMenu = new CustomerManagerMenu();
        InvoiceManagementMenu invoiceManagementMenu = new InvoiceManagementMenu();

        display();
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1 -> bookManagementMenu.Menu();
                case 2 -> customerManagerMenu.menu();
                case 3 -> invoiceManagementMenu.meNu();
                default -> System.out.println("Lựa chọn của bạn không tìm thấy!");
            }
            display();
            choice = sc.nextInt();
            sc.nextLine();
        }
    }

    private static void display(){
        System.out.println("---------Menu--------");
        System.out.println("1. Menu Sách");
        System.out.println("2. Danh sách khách hàng");
        System.out.println("3. Danh sách hoá đơn");
        System.out.println("0. Thoát");
        System.out.println("Nhập lựa chọn của bạn");
    }
}