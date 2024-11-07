package org.example.trabalhoapresentar;

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

public class MenuController {

    @FXML
    private Button btnProduto, btnInventario;

    private static List<Produto> produtosDisponiveis = new ArrayList<>();

    public void initialize() {
        carregarProdutos();

        btnProduto.setOnAction(event -> abrirTelaProdutos());
        btnInventario.setOnAction(event -> abrirTelaInventario());
    }

    private void carregarProdutos() {
        produtosDisponiveis.add(new Produto("001", "Teclado"));
        produtosDisponiveis.add(new Produto("002", "Mouse"));
        produtosDisponiveis.add(new Produto("003", "Monitor"));
        produtosDisponiveis.add(new Produto("004", "Gabinete"));
        produtosDisponiveis.add(new Produto("005", "Fonte de Alimentação"));
    }

    public static List<Produto> getProdutosDisponiveis() {
        return produtosDisponiveis;
    }

    private void abrirTelaProdutos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("produtos.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Consultar Estoque Atual");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaInventario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inventario.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Inventário");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
