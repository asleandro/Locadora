package com.example.locadora.adapter;

import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
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

    public FerramentasAdapter(List<Produto> produtos, Usuario usuario) {
        this.produtos = produtos;
        this.usuario = usuario;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeProduto;
        private TextView descricaoProduto;
        private TextView textoValorDoAluguel;
        private TextView precoProduto;
        private ImageView imagemProduto;
        private AppCompatImageButton adicionarCarrinho;
        private SearchView searchView;

        public ViewHolder(View view) {
            super(view);

            nomeProduto = view.findViewById(R.id.nome_produto);
            descricaoProduto = view.findViewById(R.id.descricao_produto);
            textoValorDoAluguel = view.findViewById(R.id.valor_do_aluguel);
            precoProduto = view.findViewById(R.id.preco_produto);
            imagemProduto = view.findViewById(R.id.imagem_produto);
            adicionarCarrinho = view.findViewById(R.id.btnAdicionaCarrinho);
            searchView = view.findViewById(R.id.searchView);
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
        public SearchView getSearchView(){
            return searchView;
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
        holder.precoProduto.setText(produto.getValorFormatado(produto.getValor()));

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

    public void filtrarLista(List<Produto> listaFiltrada) {
        this.produtos = listaFiltrada;
        notifyDataSetChanged();
    }

}
