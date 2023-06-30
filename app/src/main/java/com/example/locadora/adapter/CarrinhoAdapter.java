package com.example.locadora.adapter;

import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locadora.R;
import com.example.locadora.fragmentos.CarrinhoFragment;
import com.example.locadora.model.Produto;
import com.example.locadora.model.Usuario;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    private OnItemRemovedListener onItemRemovedListener;
    private List<Produto> carrinho;
    private Usuario usuario;

    public CarrinhoAdapter(List<Produto> carrinho, Usuario usuario, OnItemRemovedListener onItemRemovedListener) {
        this.carrinho = carrinho;
        this.usuario = usuario;
        this.onItemRemovedListener = onItemRemovedListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeProduto;
        private TextView precoProduto;
        private TextView textoValorDoAluguel;
        private ImageView imagemProduto;
        private AppCompatImageButton removerCarrinho;

        public ViewHolder(View view){
            super(view);

            nomeProduto = view.findViewById(R.id.nome_produto);
            textoValorDoAluguel = view.findViewById(R.id.valor_do_aluguel);
            precoProduto = view.findViewById(R.id.preco_produto);
            imagemProduto = view.findViewById(R.id.imagem_produto);
            removerCarrinho = view.findViewById(R.id.btnRemoverCarrinho);
        }

        public TextView getNomeProduto() {
            return nomeProduto;
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
    public CarrinhoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_carrinho, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoAdapter.ViewHolder holder, int position) {
        Produto produto = (Produto) carrinho.get(position);

        holder.nomeProduto.setText(produto.getNome());
        holder.textoValorDoAluguel.setText("Valor do aluguel: R$");
        holder.getImagemProduto().setImageResource(produto.getImagemId());
        holder.precoProduto.setText(produto.getValorFormatado(produto.getValor()));

        holder.removerCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.removeDoCarrinho(produto);
                onItemRemovedListener.onItemRemoved();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (carrinho != null){
            return carrinho.size();
        }
        return 0;
    }

    public interface OnItemRemovedListener{
        void onItemRemoved();
    }
}
