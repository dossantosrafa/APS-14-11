package org.example.trabalhoapresentar;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ProdutosController {

    @FXML
    private ListView<Produto> listaProdutos;

    public void initialize() {
        listaProdutos.getItems().addAll(MenuController.getProdutosDisponiveis());
    }
}
