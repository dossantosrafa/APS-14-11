package org.example.trabalhoapresentar;

// Importa as classes necessárias do JavaFX
import javafx.fxml.FXML;
import javafx.scene.control.Label;

// Define a classe do controlador da interface
public class HelloController {

    @FXML
    private Label welcomeText;

    // Método que será chamado quando o botão na interface for clicado
    @FXML
    protected void onHelloButtonClick() {
        // Altera o texto do Label para "Welcome to JavaFX Application!" quando o botão for clicado
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
