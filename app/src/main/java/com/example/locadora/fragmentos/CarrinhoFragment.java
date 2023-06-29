package com.example.locadora.fragmentos;

import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.locadora.R;
import com.example.locadora.adapter.CarrinhoAdapter;
import com.example.locadora.model.Produto;
import com.example.locadora.model.Usuario;

import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarrinhoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarrinhoFragment extends Fragment {

    private List<Produto> carrinho;
    private RecyclerView recyclerView;
    private CarrinhoAdapter adapter;
    private Usuario usuario;
    private TextView total;
    private double valorTotal;

    public CarrinhoFragment() {
        // Required empty public constructor
    }

    public static CarrinhoFragment newInstance(Usuario usuario, List<Produto> carrinho) {
        CarrinhoFragment fragment = new CarrinhoFragment();
        fragment.usuario = usuario;
        fragment.carrinho = carrinho;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        total = view.findViewById(R.id.valorPedido);

        somaValorTotal();

        // está dando problema pq carrinho está null.
        System.out.println(!carrinho.isEmpty());
        /*if (!carrinho.isEmpty()) {
            for (Produto produto : carrinho) {
                valorTotal += produto.getValor();
            }
        }*/

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        String valorFormatado = decimalFormat.format(valorTotal);
        total.setText(valorFormatado);


        //mudei os parametros passados para o adapter de (carrinho ,usuario) para usuario.getCarrinho(), usuario)
        adapter = new CarrinhoAdapter(usuario.getCarrinho(), usuario, new CarrinhoAdapter.OnItemRemovedListener() {
            @Override
            public void onItemRemoved() {
                somaValorTotal();
                String novoTotal = decimalFormat.format(valorTotal);
                total.setText(novoTotal);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        return view;
    }

    private void somaValorTotal() {
        valorTotal = 0;
        if (!carrinho.isEmpty()) {
            for (Produto produto : carrinho) {
                valorTotal += produto.getValor();
            }
        }
    }
}