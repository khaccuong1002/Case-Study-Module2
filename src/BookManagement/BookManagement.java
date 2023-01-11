package BookManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
 
public class BookManagement {
    private ArrayList<Book> listBook;

    private static BookManagement bookManagement = new BookManagement();

    private BookManagement(){
        listBook = new ArrayList<>();
        readFromFile();
    }

    public static BookManagement getBookManagement(){
        return bookManagement;
    }

    public static void setBookManagement(BookManagement bookManagement){
        BookManagement.bookManagement = bookManagement;
    }

    public void addBook(Book book){
        listBook.add(book);
        saveFile();
    }

    public boolean fixBook(String idBook, String nameBook, String author, String category, int quantity){
        for (Book book: listBook){
            if (book.getIdBook().equals(idBook)){
                book.setNameBook(nameBook);
                book.setAuthor(author);
                book.setCategory(category);
                book.setQuantity(quantity);
                return true;
            }
        }
        return false;
    }

    public boolean removeBook(String idBook){
        for(Book book: listBook){
            if (book.getIdBook().equals(idBook)){
                listBook.remove(book);
                return true;
            }
        }
        return false;
    }

    public Book searchById(String id){
        for (Book book: listBook){
            if(book.getIdBook().equals(id)){
                return book;
            }
        }
        return null;
    }

    public boolean searchByName(String name){
        for (Book book: listBook){
            if(book.getNameBook().equals(name)){
                System.out.println(book);
                return true;
            }
        }
        return false;
    }

    public boolean searchCategory(String category){
        for (Book book: listBook){
            if (book.getCategory().equals(category)){
                System.out.println(book);
                return true;
            }
        }
        return false;
    }

    public void sortByAtoZ(){
        ComparatorBook comparatorBook = new ComparatorBook();

        listBook.sort(comparatorBook);
        System.out.println(listBook);
    }

    public void sortByZtoA(){
        ComparatorBook comparatorBook = new ComparatorBook();

        Collections.sort(listBook, comparatorBook.reversed());
        System.out.println(listBook);
    }

    public boolean checkIdBook(String id){
        for(Book book: listBook){
            if (book.getIdBook().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void display(){
        System.out.println(listBook);
    }

    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter("book.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Book b: listBook){
                bufferedWriter.write(b.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void readFromFile(){
        listBook.clear();
        try {
            FileReader fileReader = new FileReader("book.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Book book = handleLine(line);
                listBook.add(book);
                System.out.println(book);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Book handleLine(String line) {
        String[] strings = line.split(",");
        return new Book(strings[0], strings[1], strings[2], strings[3], Integer.parseInt(strings[4]), Double.parseDouble(strings[5]));
    }

    @Override
    public String toString(){
        return "BookManagement{ " + "\n" +
                "listBook: " + listBook + "\n";
    }
}
