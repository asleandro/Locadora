package com.example.locadora.model;

import android.graphics.Bitmap;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;

import java.util.Locale;

public class Produto {
    private String nome;
    private String descricao;
    private double valor;
    private int imagemId;

    public Produto(){

    }

    public Produto(String nome, String descricao, double valor, int imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagemId = imagem;
    }

    public int getImagemId() {
        return imagemId;
    }

    public void setImagemId(int imagemId) {
        this.imagemId = imagemId;
    }

    /*public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }*/

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValorFormatado(double valor){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        String valorFormatado = decimalFormat.format(valor);
        return valorFormatado;
    }
}
