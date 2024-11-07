module org.example.trabalhoapresentar {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.trabalhoapresentar to javafx.fxml;
    exports org.example.trabalhoapresentar;
}
