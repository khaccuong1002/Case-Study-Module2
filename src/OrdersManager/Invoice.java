package OrdersManager;

import BookManagement.Book;
import BookManagement.BookManagement;
import CustomerManagement.CustomerManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice {
    private String idInvoice;
    private String idCustomer;
    private String idBooks;
    private Date date;
    private Map<String, Integer> hashMap;

    CustomerManager customerManager = CustomerManager.getCustomerManager();
    BookManagement bookManagement = BookManagement.getBookManagement();

    public Invoice() {
    }

    public Invoice(String idInvoice, String idCustomer, String idBooks, String nameCustomer) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.idBooks = idBooks;
        this.date = new Date();
        this.hashMap = new HashMap<>();
    }

    public Invoice(String idInvoice, String idCustomer, String idBooks, Date date, Map<String, Integer> hashMap) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.idBooks = idBooks;
        this.date = date;
        this.hashMap = hashMap;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(String idBooks) {
        this.idBooks = idBooks;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Integer> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void addBooks(String idBooks, int quantity){
        hashMap.put(idBooks, quantity);
    }

    public double getSubTotal(String idBooks, int quantity){
        Book book = bookManagement.searchById(idBooks);
        double result;
        double priceOfBook = book.getPrice();
        result = priceOfBook * quantity;
        return result;
    }

    public double getTotal(){
        double total = 0;
        for (String key: getHashMap().keySet()){
            total += getSubTotal(key, getHashMap().get(key));
        }
        return total;
    }

    public String getBookInformation(){
        StringBuilder result = new StringBuilder();
        for (String key : hashMap.keySet()){
            String id = bookManagement.searchById(key).getIdBook();
            result.append(id).append(",").append(bookManagement.searchById(id).getNameBook()).append(",")
                    .append(hashMap.get(key)).append(",");
        }
        return result.toString();
    }

    public String stringCreatedDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(getDate());
    }

    public String toFileInvoice(){
        return idInvoice + "," + idCustomer + idBooks + "," + date + hashMap;
    }

    @Override
    public String toString() {
        return "-------Invoice-------" + "\n" +
                "ID hoá đơn" + idInvoice + "\n" +
                "Ngày: " + idCustomer + "\n" +
                "Tên KH: " + idBooks + "\n" +
                "Sản phẩm: " + date + "\n" +
                "Tổng hoá đơn: " + hashMap + "\n";
    }
}
