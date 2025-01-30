package bookcollections;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class LibraryController {
    private final Library library = new Library();

    @FXML
    private ListView<String> bookListView;

    @FXML
    public void initialize() {
        // Load books from the CSV file
        String csvFilePath = getClass().getResource("/books.csv").getPath();
        library.loadBooksFromCSV(csvFilePath);
        updateBookList();
    }

    @FXML
    private void updateBookList() {
        bookListView.getItems().clear();
        for (Book book : library.getCollection()) { // Access the collection directly
            bookListView.getItems().add(book.toString());
        }
    }

    /*@FXML
    private void removeSelectedBook() {
          String selected = bookListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String[] parts = selected.split(","); // Parse to extract ISBN
            String isbn = parts[2].trim();
            library.removeBook(isbn);
            updateBookList();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a book to remove.");
            alert.showAndWait();
        }
    }*/
}

