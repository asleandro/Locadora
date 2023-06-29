package com.example.locadora.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.locadora.MainActivity;
import com.example.locadora.R;
import com.example.locadora.adapter.FerramentasAdapter;
import com.example.locadora.model.Produto;
import com.example.locadora.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FerramentasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FerramentasFragment extends Fragment {

    private List<Produto> produtos;
    private RecyclerView recyclerView;
    private FerramentasAdapter adapter;
    private Usuario usuario;
    private SearchView searchView;

    public FerramentasFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FerramentasFragment newInstance(Usuario usuario) {
        FerramentasFragment fragment = new FerramentasFragment();
        fragment.usuario = usuario;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ferramentas, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        searchView = view.findViewById(R.id.searchView);
        recyclerView.setHasFixedSize(true);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrarLista(newText);
                return false;
            }
        });

        Produto p1 = new Produto("Furadeira de impacto", "Executa furos em madeira, metal e alvenaria.\n" +
                "A furadeira de impacto capaz de realizar tarefas com precisão e com pouco esforço físico do operador",
                109.90, R.drawable.furadeira_impacto);
        Produto p2 = new Produto("Aparador de cerca viva", "Utilizado para aparar cercas vivas, \"eras\"," +
                " sebes e arbustos, que tenham galhos com diâmetro menor que 1 cm.",
                165.50, R.drawable.aparador_cerca_viva);
        Produto p3 = new Produto("Martelo demolidor", "Indicado para demolição de alvenaria, pequenas vigas e" +
                "pilares de concreto, revestimento de pisos e concreto magro.", 180.50, R.drawable.martelo_demolidor);
        Produto p4 = new Produto("Esmerilhadeira", "Indicada para esmerilhar e também realizar corte em" +
                "alvenaria e metal", 145.00, R.drawable.esmerilhadeira);
        Produto p5 = new Produto("Esquadrilhadeira", "Também conhecida como Serra Esquadria, é um equipamento" +
                "prático para trabalhos pesados de corte", 195.50, R.drawable.esquadrilhadeira);
        Produto p6 = new Produto("Cortadora de grama elétrica", "Indicada para o corte de grama e capim" +
                "com baixa altura.", 120.45, R.drawable.cortador_grama);
        Produto p7 = new Produto("Cortadora de grama gasolina", "Indicada para o corte de grama e capim" +
                "com baixa altura.", 165.65, R.drawable.cortador_grama_gasolina);

        produtos = new ArrayList<>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        produtos.add(p5);
        produtos.add(p6);
        produtos.add(p7);

        //adapter.notifyDataSetChanged();
        //adapter = new FerramentasAdapter(produtos);
        adapter = new FerramentasAdapter(produtos, usuario);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        return view;
    }

    private void filtrarLista(String newText) {
        List<Produto> listaFiltrada = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(newText.toLowerCase())) {
                listaFiltrada.add(produto);
            }
        }
        if (!listaFiltrada.isEmpty()) {
            adapter.filtrarLista(listaFiltrada);
        } else Toast.makeText(getActivity(), "nenhum resultado encontrado", Toast.LENGTH_SHORT).show();

    }
}