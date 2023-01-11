package OrdersManager;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class InvoiceManagement {
    private static List<Invoice> listInvoice;

    private InvoiceManagement(){
//        listInvoice = new ArrayList<>();
    }
    static {
        listInvoice = new ArrayList<>();
        HashMap<String,Integer> hashMap =new HashMap<>();
        hashMap.put("1",1);
        listInvoice.add(new Invoice("1","1","1", "1"));
    }

    private static InvoiceManagement invoiceManagement = new InvoiceManagement();

    public static InvoiceManagement getInvoiceManagement() {
        return invoiceManagement;
    }

    public void addInvoice(Invoice invoice){
        listInvoice.add(invoice);
    }

    public Invoice searchById(String id){
        for (Invoice invoice: listInvoice){
            if (invoice.getIdInvoice().equals(id)){
                return invoice;
            }
        }
        return null;
    }

    public boolean checkIdInvoice(String id){
        for (Invoice invoice: listInvoice){
            if (invoice.getIdInvoice().equals(id)){
                return true;
            }
        }
        return false;
    }

    public boolean remove(String id){
        for (Invoice invoice: listInvoice){
           if (invoice.getIdInvoice().equals(id)){
               listInvoice.remove(invoice);
               return true;
           }
        }
        return false;
    }

    public List<Invoice> displayInvoice(){
        return listInvoice;
    }

    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter("invoice.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Invoice invoice: listInvoice){
                bufferedWriter.write(invoice.toFileInvoice());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void readFromFileInvoice(){
        listInvoice.clear();
        try {
            FileReader fileReader = new FileReader("invoice.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Invoice invoice = handleLine(line);
                listInvoice.add(invoice);
                System.out.println(invoice);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException | ParseException e){
            throw new RuntimeException(e);
        }
    }

    private Invoice handleLine(String line) throws ParseException {
      String[] strings = line.split(",");
        System.out.println(strings);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Invoice invoice = new Invoice(strings[0], simpleDateFormat.parse(strings[1]), strings[2], strings[3], strings[4], );
//        for (int i = 3; i < strings.length -2; i+=3) {
//            invoice.addBooks(strings[i], Integer.parseInt(strings[i + 2]));
//        }
//        return invoice;
        return null;
    }

    public Invoice searchInvoiceByDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Invoice invoice: listInvoice){
            String dateFormat = simpleDateFormat.format(invoice.getDate());
            if (dateFormat.equals(date)){
                return invoice;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "InvoiceManagement" + "listInvoice" + listInvoice + "}";
    }

    public static void main(String[] args) {
        new InvoiceManagement().saveFile();
    }
}
