package OrdersManager;

import BookManagement.Book;
import BookManagement.BookManagement;
import CustomerManagement.CustomerManager;

import java.util.Date;
import java.util.Scanner;

public class InvoiceManagementMenu {
    Scanner sc = new Scanner(System.in);
    InvoiceManagement invoiceManagement = InvoiceManagement.getInvoiceManagement();

    BookManagement bookManagement = BookManagement.getBookManagement();

    CustomerManager customerManager = CustomerManager.getCustomerManager();

    public InvoiceManagementMenu(){
    }

    public void meNu(){
        int choice = 0;
        do {
            System.out.println("--------Menu Invoice-------");
            System.out.println("1. Thêm hoá đơn");
            System.out.println("2. Xoá hoá đơn");
            System.out.println("3. Tìm hoá đơn");
            System.out.println("4. Hiển thị danh sách hoá đơn");
            System.out.println("5. Đọc file");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> addinvoice();
                case 2 -> remove();
                case 3 -> search();
                case 4 -> display();
                case 5 -> invoiceManagement.readFromFileInvoice();
                default -> System.out.println("Lựa chọn của bạn không tồn tại");
            }
        } while (choice != 0);
    }

    private void addinvoice(){
        System.out.println("Nhập ID hoá đơn: ");
        String idInvoice = sc.nextLine();
        while (invoiceManagement.checkIdInvoice(idInvoice)){
            System.out.println("ID hoá đơn đã tồn tại. Vui lòng nhập lại!");
            idInvoice = sc.nextLine();
        }
        System.out.println("Nhập ID Khách hàng: ");
        String idCustomer = sc.nextLine();
        while (!customerManager.checkByID(idCustomer)){
            System.out.println("ID khách hàng khong tồn tại. Vui lòng nhập lại!");
            idCustomer = sc.nextLine();
        }
        Date createDay = new Date();
//        Invoice invoice = new Invoice(idInvoice, createDay, idCustomer);
        int choice = -1;

        while (choice != 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập ID sản phẩm: ");
            String idBook = sc.nextLine();
            Book book  = bookManagement.searchById(idBook);
            while (!bookManagement.checkIdBook(idBook)){
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại");
                idBook = sc.nextLine();

            }
            System.out.println("Nhập số lượng muốn mua: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            if (book.getQuantity() - quantity > 0 || book.getQuantity() - quantity == 0) {
                book.setQuantity(book.getQuantity() - quantity);
//                invoice.addBooks(idBook, quantity);

                bookManagement.saveFile();
            } else {
                System.out.println("Sản phẩm này hiện tại đã hết hàng !");
            }
            System.out.println("1. Bạn muốn mua thêm không?");
            System.out.println("0. Thoát");
            choice = sc.nextInt();
            sc.nextLine();
        }
//        invoiceManagement.addInvoice(invoice);
        invoiceManagement.saveFile();
    }

    private void remove(){
        System.out.println("Nhập ID muốn xoá: ");
        String id = sc.nextLine();

        invoiceManagement.remove(id);
    }

    private void search(){
        System.out.println("Nhập ID hoá đơn muốn tìm: ");
        String id = sc.nextLine();

        invoiceManagement.searchById(id);
    }

    private void display(){
        System.out.println(invoiceManagement.displayInvoice());
    }

}
