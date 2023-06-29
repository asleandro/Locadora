package com.example.locadora.model;

import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Usuario {

    private String email;
    private String senha;
    private List<Produto> carrinho = new ArrayList<>();

    private boolean login = false;

    public void adicionaAoCarrinho(Produto produto){
        if (carrinho == null){
            carrinho = new ArrayList<>();
        }
        this.carrinho.add(produto);
    }

    public void removeDoCarrinho(Produto produto){
        if(carrinho != null){
            this.carrinho.remove(produto);
        }
    }

    public String getTotalCarrinho(){
        int valorTotal = 0;
        String valorFormatado;
        if(!this.carrinho.isEmpty()){
            for(Produto produto : carrinho){
                valorTotal += produto.getValor();
            }
        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        valorFormatado = decimalFormat.format(valorTotal);

        return valorFormatado;
    }

    public List<Produto> getCarrinho(){
        return carrinho;
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

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
