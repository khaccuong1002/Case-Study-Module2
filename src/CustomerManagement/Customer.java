package CustomerManagement;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private String address;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String idCustomer, String nameCustomer, String address, String phoneNumber) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        String result = "";
        result += "\n" +
                "----Thông tin khách hàng----" + "\n" +
                "Mã ID: " + idCustomer + "\n" +
                "Họ và Tên: " + nameCustomer + "\n" +
                "Địa chỉ: " + address + "\n" +
                "Số điện thoại: " + phoneNumber + "\n";
        return result;
    }

    public String toFile() {
        return idCustomer + "," + nameCustomer + "," + address + "," + phoneNumber ;
    }
}
