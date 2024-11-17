package org.example.trabalhoapresentar;

// Define a classe Produto que representa um produto com código e nome
public class Produto {
    private String codigo; // Atributo que armazena o código do produto
    private String nome;   // Atributo que armazena o nome do produto

    // Construtor da classe que inicializa os atributos 'codigo' e 'nome'
    public Produto(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Método para obter o código do produto
    public String getCodigo() {
        return codigo;
    }

    // Método para obter o nome do produto
    public String getNome() {
        return nome;
    }

    // Método toString que retorna uma representação textual do produto
    @Override
    public String toString() {
        return codigo + " - " + nome; // Exibe o código seguido do nome do produto
    }
}
