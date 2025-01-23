import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LibraryManager extends Application {
    private Library library = new Library();
    private ListView<String> bookListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        // Load books from the CSV file
        String csvFilePath = "books.csv"; // Ensure the file exists at this path
        library.loadBooksFromCSV(csvFilePath);
        updateBookList();

        // Layout setup
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label title = new Label("Library Manager");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button removeButton = new Button("Remove Selected Book");
        Button refreshButton = new Button("Refresh");

        HBox buttons = new HBox(10, removeButton, refreshButton);
        buttons.setPadding(new Insets(10));

        root.getChildren().addAll(title, bookListView, buttons);

        // Event handlers
        removeButton.setOnAction(e -> removeSelectedBook());
        refreshButton.setOnAction(e -> updateBookList());

        // Scene setup
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Library Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateBookList() {
        bookListView.getItems().clear();
        for (Book book : library.collection) { // Access the collection directly
            bookListView.getItems().add(book.toString());
        }
    }

    private void removeSelectedBook() {
        String selected = bookListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String[] parts = selected.split(","); // Parse to extract ISBN
            String isbn = parts[2].trim();
            library.removeBook(isbn);
            updateBookList();
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}

