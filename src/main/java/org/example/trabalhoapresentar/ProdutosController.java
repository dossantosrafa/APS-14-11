package org.example.trabalhoapresentar;

// Importa as classes necessárias do JavaFX
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

// Define a classe que controla a tela de consulta de produtos
public class ProdutosController {

    // Define o ListView que irá exibir a lista de produtos na interface gráfica
    @FXML
    private ListView<Produto> listaProdutos;

    // Método chamado automaticamente quando o controlador é inicializado
    public void initialize() {
        // Adiciona todos os produtos disponíveis na lista para exibição
        listaProdutos.getItems().addAll(MenuController.getProdutosDisponiveis());
    }
}
