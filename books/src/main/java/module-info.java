module bookcollections {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens bookcollections to javafx.fxml;
    exports bookcollections;
}
