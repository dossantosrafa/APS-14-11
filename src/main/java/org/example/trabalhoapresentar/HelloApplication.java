package org.example.trabalhoapresentar;

// Importa as bibliotecas necessárias do JavaFX
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Define a classe principal que estende (herda) a classe Application do JavaFX
public class HelloApplication extends Application {

    // Método que será chamado quando a aplicação iniciar
    @Override
    public void start(Stage stage) throws IOException {
        // O FXMLLoader carrega o arquivo FXML que define a interface gráfica
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Cria uma nova cena (uma janela) com o layout do arquivo FXML carregado,
        // e define o tamanho da janela como 320x240 pixels
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Define o título da janela (o nome que aparece na parte superior da janela)
        stage.setTitle("Aplicação de Inventário");

        // Define a cena (a interface) que será exibida na janela
        stage.setScene(scene);

        // Exibe a janela com o conteúdo (a cena) definida acima
        stage.show();
    }

    // Método principal, que é a entrada da aplicação (onde o programa começa a rodar)
    public static void main(String[] args) {
        // Lança a aplicação JavaFX
        launch();
    }
}
