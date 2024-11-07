package org.example.trabalhoapresentar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class InventarioController {

    @FXML
    private TextField txtCodigoProduto;
    @FXML
    private Button btnFinalizarContagem;
    @FXML
    private ListView<String> listaProdutos;

    private List<String> produtosContados = new ArrayList<>();

    public void initialize() {
        txtCodigoProduto.setOnKeyPressed(this::onEnterPressed);
        btnFinalizarContagem.setOnAction(event -> finalizarContagem());
    }

    private void onEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String codigoProduto = txtCodigoProduto.getText();
            boolean produtoEncontrado = MenuController.getProdutosDisponiveis()
                    .stream()
                    .anyMatch(produto -> produto.getCodigo().equals(codigoProduto));

            if (produtoEncontrado) {
                produtosContados.add(codigoProduto);
                listaProdutos.getItems().add("Produto " + codigoProduto + " adicionado");
                txtCodigoProduto.clear();
            } else {
                listaProdutos.getItems().add("Produto " + codigoProduto + " não encontrado");
                txtCodigoProduto.clear();
            }
        }
    }

    private void finalizarContagem() {
        System.out.println("Contagem finalizada com " + produtosContados.size() + " produtos contados.");
    }
}
