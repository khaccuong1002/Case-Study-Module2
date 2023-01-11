package CustomerManagement;

import BookManagement.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CustomerManager {
    private static ArrayList<Customer> customers;

    private static CustomerManager customerManager = new CustomerManager();

    private CustomerManager(){
        customers = new ArrayList<>();
        readFromFile();
    }

    public static CustomerManager getCustomerManager(){
        return customerManager;
    }

    public static void setCustomerManager(CustomerManager customerManager){
        CustomerManager.customerManager = customerManager;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        saveFile();
    }

    public boolean fixCustomer(String idCustomer, String nameCustomer, String address, String phoneNumber){
        for(Customer customer: customers){
            if(customer.getIdCustomer().equals(idCustomer)){
                customer.setNameCustomer(nameCustomer);
                customer.setAddress(address);
                customer.setPhoneNumber(phoneNumber);
                return true;
            }
        }
        return false;
    }

    public boolean removeCustomer(String idCustomer){
        for(Customer customer : customers) {
            if(customer.getIdCustomer().equals(idCustomer)){
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    public boolean searchByName(String name){
        for(Customer customer: customers){
            if(customer.getNameCustomer().equals(name)){
                System.out.println(customer);
                return true;
            }
        }
        return false;
    }

    public void sortUp(){
        ComparatorCustomer comparatorCustomer = new ComparatorCustomer();

        customers.sort(comparatorCustomer);
        System.out.println(customers);
    }

    public void sortDescending(){
        ComparatorCustomer comparatorCustomer = new ComparatorCustomer();

        Collections.sort(customers, comparatorCustomer.reversed());
        System.out.println(customers);
    }

    public void display(){
        System.out.println(customers);
    }

    public boolean checkByID(String id){
        for(Customer customer: customers){
            if(customer.getIdCustomer().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter("customer.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer: customers){
                bufferedWriter.write(customer.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void readFromFile(){
        customers.clear();
        try {
            FileReader fileReader = new FileReader("customer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Customer customer = handleLine(line);
                customers.add(customer);
                System.out.println(customer);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private Customer handleLine(String line){
        String[] strings = line.split(",");
        return new Customer(strings[0], strings[1], strings[2], strings[3]);
    }

    @Override
    public String toString() {
        return "CustomerManager{ " + "\n" +
                "customers: " + customers + "\n";
    }
}
