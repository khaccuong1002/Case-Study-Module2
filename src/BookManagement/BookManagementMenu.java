package BookManagement;

import java.util.Scanner;

public class BookManagementMenu {

    public BookManagementMenu(){}

    BookManagement bookManagement = BookManagement.getBookManagement();

    Scanner sc = new Scanner(System.in);

    public void Menu(){
        bookManagement.readFromFile();
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("--------MENU BOOK--------");
            System.out.println("1. Thêm thông tin sách");
            System.out.println("2. Sửa thông tin sách");
            System.out.println("3. Xoá thông tin sách");
            System.out.println("4. Tìm tên sách");
            System.out.println("5. Tìm thể loại sách");
            System.out.println("6. Sắp xếp tên tăng dần từ A-Z");
            System.out.println("7. Sắp xếp tên giảm dần từ Z-A");
            System.out.println("8. Hiển thị danh sách");
            System.out.println("9. Đọc file");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> addbook();
                case 2 -> fixbook();
                case 3 -> removebook();
                case 4 -> searchbook();
                case 5 -> searchcategory();
                case 6 -> sortAtoZ();
                case 7 -> sortZtoA();
                case 8 -> display();
                case 9 -> read();
                default -> System.out.println("Lựa chọn của bạn không tìm thấy");
            }
        } while(choice != 0);
    }

    private void read(){
        bookManagement.readFromFile();
    }

    private void display(){
        bookManagement.display();
    }

    private void sortZtoA(){
        bookManagement.sortByZtoA();
    }

    private void sortAtoZ(){
        bookManagement.sortByAtoZ();
    }

    private void searchbook(){
        System.out.println("Nhập tên sách bạn muốn tìm kiếm: ");
        String idBook = sc.nextLine();

        bookManagement.searchByName(idBook);
    }

    private void searchcategory(){
        System.out.println("Nhập thể loại sách bạn muốn tìm kiếm: ");
        String category = sc.nextLine();

        bookManagement.searchCategory(category);
    }

    private void removebook(){
        System.out.println("Nhập ID sách muốn xoá: ");
        String idBook = sc.nextLine();

        bookManagement.removeBook(idBook);
    }

    private void fixbook(){
        System.out.println("Nhập ID sách bạn muốn sửa: ");
        String idBook = sc.nextLine();
        System.out.println("Nhập tên sách bạn muốn sửa: ");
        String nameBook = sc.nextLine();
        System.out.println("Nhập tên tác giả bạn muốn sửa: ");
        String author = sc.nextLine();
        System.out.println("Nhập thể loại sách bạn muốn sửa: ");
        String category = sc.nextLine();
        System.out.println("Nhập số lượng sách bạn muốn sửa: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        bookManagement.fixBook(idBook, nameBook, author, category, quantity);
    }

    private void addbook(){
        System.out.println("Nhập mã ID sách: ");
        String idBook = sc.nextLine();
        System.out.println("Nhập tên sách: ");
        String nameBook = sc.nextLine();
        System.out.println("Nhập tên tác giả: ");
        String author = sc.nextLine();
        System.out.println("Nhập thể loại sách: ");
        String category = sc.nextLine();
        System.out.println("Nhập số lượng sách: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap gia san pham: ");
        Double price = sc.nextDouble();
        sc.nextLine();

        Book book = new Book(idBook, nameBook, author, category, quantity, price);
        bookManagement.addBook(book);
    }
}
