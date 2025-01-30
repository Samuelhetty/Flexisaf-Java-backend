package bookcollections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> collection;


    // Constructor
    public Library() {
        collection = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        collection.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    // Method to remove a book by ISBN
    public void removeBook(String ISBN) {
        for (Book book : collection) {
            if (book.getISBN().equals(ISBN)) {
                collection.remove(book);
                System.out.println(book.getTitle() + " has been removed from the library.");
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }

    // Method to display all books
    public void displayBooks() {
        if (collection.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : collection) {
                System.out.println(book);
            }
        }
    }
    
    // Method to load books from a CSV file
    public void loadBooksFromCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true; // Skip the header
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    String ISBN = parts[2].trim();
                    Book book = new Book(title, author, ISBN);
                    addBook(book);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
    // Getter for the collection (used by the controller)
    public List<Book> getCollection() {
        return collection;
    }
}