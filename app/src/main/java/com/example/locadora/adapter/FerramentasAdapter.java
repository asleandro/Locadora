package com.example.locadora.adapter;

import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locadora.R;
import com.example.locadora.model.Produto;
import com.example.locadora.model.Usuario;

import java.util.List;
import java.util.Locale;


public class FerramentasAdapter extends RecyclerView.Adapter<FerramentasAdapter.ViewHolder> {
    private List<Produto> produtos;
    private Usuario usuario;

    /*public FerramentasAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }*/

    public FerramentasAdapter(List<Produto> produtos, Usuario usuario) {
        this.produtos = produtos;
        this.usuario = usuario;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView nomeProduto;
        private TextView descricaoProduto;
        private TextView textoValorDoAluguel;
        private TextView precoProduto;
        private ImageView imagemProduto;
        private AppCompatImageButton adicionarCarrinho;
        //private Usuario usuario;

        public ViewHolder(View view) {
            super(view);

            nomeProduto = view.findViewById(R.id.nome_produto);
            descricaoProduto = view.findViewById(R.id.descricao_produto);
            textoValorDoAluguel = view.findViewById(R.id.valor_do_aluguel);
            precoProduto = view.findViewById(R.id.preco_produto);
            imagemProduto = view.findViewById(R.id.imagem_produto);
            adicionarCarrinho = view.findViewById(R.id.btnAdicionaCarrinho);
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getNomeProduto() {
            return nomeProduto;
        }

        public TextView getDescricaoProduto() {
            return descricaoProduto;
        }

        public TextView getTextoValorDoAluguel() {
            return textoValorDoAluguel;
        }

        public TextView getPrecoProduto() {
            return precoProduto;
        }

        public ImageView getImagemProduto() {
            return imagemProduto;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = (Produto) produtos.get(position);

        holder.nomeProduto.setText(produto.getNome());
        holder.descricaoProduto.setText(produto.getDescricao());
        holder.textoValorDoAluguel.setText("Valor do aluguel: R$");
        holder.getImagemProduto().setImageResource(produto.getImagemId());

        double preco = produto.getValor();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        String precoFormatado = decimalFormat.format(preco);
        holder.precoProduto.setText(precoFormatado);

       holder.adicionarCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.adicionaAoCarrinho(produto);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (produtos != null) {
            return produtos.size();
        } else {
            return 0;
        }
    }
}
