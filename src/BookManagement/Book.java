package BookManagement;

public class Book {
    private String idBook;
    private String nameBook;
    private String author;
    private String category;
    private int quantity;
    private Double price;


    public Book(String idBook, String nameBook, String author, String category, int quantity, Double price) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n" +
                "----Thông tin sách----" + "\n" +
                "Mã ID sách: " + idBook + "\n" +
                "Tên sách: " + nameBook + "\n" +
                "Thể loại: " + category + "\n" +
                "Tác giả: " + author + "\n" +
                "Số lượng: " + quantity + "\n" +
                "Giá: " + price + "\n";
    }

    public String toFile() {
        return idBook + "," + nameBook + "," + author + "," + category + "," + quantity + "," + price ;
    }
}
