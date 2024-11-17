package org.example.trabalhoapresentar;

// Importa as classes necessárias do JavaFX
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Define a classe que controla o menu da aplicação
public class MenuController {

    // Define os botões da interface gráfica
    @FXML
    private Button btnProduto, btnInventario;

    // Lista estática para armazenar os produtos disponíveis (os dados podem ser compartilhados entre várias instâncias dessa classe)
    private static List<Produto> produtosDisponiveis = new ArrayList<>();

    // Método chamado automaticamente quando o controlador é inicializado
    public void initialize() {
        // Carrega a lista de produtos disponíveis
        carregarProdutos();

        // Define os eventos de clique para os botões
        btnProduto.setOnAction(event -> abrirTelaProdutos()); // Ao clicar no botão de produtos, abre a tela de produtos
        btnInventario.setOnAction(event -> abrirTelaInventario()); // Ao clicar no botão de inventário, abre a tela de inventário
    }

    // Método que carrega uma lista de produtos (simula um banco de dados de produtos disponíveis)
    private void carregarProdutos() {
        // Adiciona produtos à lista
        produtosDisponiveis.add(new Produto("001", "Adidas Adi2000"));
        produtosDisponiveis.add(new Produto("002", "Nike Dunk Low"));
        produtosDisponiveis.add(new Produto("003", "Puma Suede"));
        produtosDisponiveis.add(new Produto("004", "Tesla Hertz"));
        produtosDisponiveis.add(new Produto("005", "Adidas Campus"));
    }

    // Método público e estático que retorna a lista de produtos disponíveis
    public static List<Produto> getProdutosDisponiveis() {
        return produtosDisponiveis;
    }

    // Método que abre a tela de consulta de produtos
    private void abrirTelaProdutos() {
        try {
            // Carrega o layout da tela de produtos a partir do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("produtos.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage(); // Cria uma nova janela (Stage)
            stage.setTitle("Consultar Estoque Atual"); // Define o título da janela
            stage.setScene(new Scene(root)); // Define a cena (conteúdo) da janela
            stage.initModality(Modality.APPLICATION_MODAL); // Define que a janela será modal (impede interação com outras janelas até ser fechada)
            stage.showAndWait(); // Exibe a janela e espera que ela seja fechada
        } catch (IOException e) {
            e.printStackTrace(); // Caso ocorra um erro, exibe a mensagem no console
        }
    }

    // Método que abre a tela de inventário
    private void abrirTelaInventario() {
        try {
            // Carrega o layout da tela de inventário a partir do arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inventario.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage(); // Cria uma nova janela (Stage)
            stage.setTitle("Inventário"); // Define o título da janela
            stage.setScene(new Scene(root)); // Define a cena (conteúdo) da janela
            stage.initModality(Modality.APPLICATION_MODAL); // Define que a janela será modal
            stage.showAndWait(); // Exibe a janela e espera que ela seja fechada
        } catch (IOException e) {
            e.printStackTrace(); // Caso ocorra um erro, exibe a mensagem no console
        }
    }
}
