package com.example.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private static List<Produto> carrinho;

    public void adicionaAoCarrinho(Produto produto){
        if (carrinho == null){
            carrinho = new ArrayList<>();
        }
        carrinho.add(produto);
    }

    public List<Produto> getProduto(){
        return new ArrayList<>(carrinho);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
