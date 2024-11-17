package org.example.trabalhoapresentar;

// Importa as classes necessárias do JavaFX
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

// Define a classe do controlador da tela de inventário
public class InventarioController {

    // A anotação @FXML indica que essas variáveis são ligadas a elementos da interface gráfica no FXML
    @FXML
    private TextField txtCodigoProduto;  // Caixa de texto onde o código do produto será inserido
    @FXML
    private Button btnFinalizarContagem; // Botão para finalizar a contagem dos produtos
    @FXML
    private ListView<String> listaProdutos; // Lista onde os produtos contados serão exibidos

    private List<String> produtosContados = new ArrayList<>(); // Lista para armazenar os códigos dos produtos contados

    // Método chamado quando a tela é inicializada
    public void initialize() {
        // Define um evento para quando uma tecla for pressionada no campo de texto (txtCodigoProduto)
        txtCodigoProduto.setOnKeyPressed(this::onEnterPressed);

        // Define o evento para o botão "Finalizar Contagem"
        btnFinalizarContagem.setOnAction(event -> finalizarContagem());
    }

    // Método que é chamado quando uma tecla é pressionada no campo de texto
    private void onEnterPressed(KeyEvent event) {
        // Verifica se a tecla pressionada foi a tecla "Enter"
        if (event.getCode() == KeyCode.ENTER) {
            // Pega o código do produto inserido pelo usuário
            String codigoProduto = txtCodigoProduto.getText();

            // Verifica se o produto com esse código existe na lista de produtos disponíveis
            boolean produtoEncontrado = MenuController.getProdutosDisponiveis()
                    .stream()  // Converte a lista de produtos em um fluxo (stream) para facilitar a busca
                    .anyMatch(produto -> produto.getCodigo().equals(codigoProduto)); // Verifica se algum produto tem o mesmo código

            // Se o produto for encontrado
            if (produtoEncontrado) {
                // Adiciona o código do produto na lista de produtos contados
                produtosContados.add(codigoProduto);
                // Adiciona a mensagem "Produto X adicionado" à lista na interface
                listaProdutos.getItems().add("Produto " + codigoProduto + " adicionado");
                // Limpa o campo de texto para o próximo código
                txtCodigoProduto.clear();
            } else {
                // Se o produto não for encontrado, adiciona a mensagem de erro à lista
                listaProdutos.getItems().add("Produto " + codigoProduto + " não encontrado");
                // Limpa o campo de texto para o próximo código
                txtCodigoProduto.clear();
            }
        }
    }

    // Método chamado quando o botão "Finalizar Contagem" é clicado
    private void finalizarContagem() {
        // Exibe no console o número de produtos que foram contados
        System.out.println("Contagem finalizada com " + produtosContados.size() + " produtos contados.");
    }
}
