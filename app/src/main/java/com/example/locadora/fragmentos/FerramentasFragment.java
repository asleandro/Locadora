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

import com.example.locadora.R;
import com.example.locadora.adapter.FerramentasAdapter;
import com.example.locadora.model.Produto;
import com.example.locadora.model.Usuario;

import java.util.ArrayList;
import java.util.List;

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


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FerramentasFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FerramentasFragment newInstance(Usuario usuario){
        FerramentasFragment fragment = new FerramentasFragment();
        fragment.usuario = usuario;
        return fragment;
    }

    /*public static FerramentasFragment newInstance(String param1, String param2) {
        FerramentasFragment fragment = new FerramentasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ferramentas, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

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
                "com baixa altura." , 120.45, R.drawable.cortador_grama);
        Produto p7 = new Produto("Cortadora de grama gasolina", "Indicada para o corte de grama e capim" +
                "com baixa altura." , 165.65, R.drawable.cortador_grama_gasolina);

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
}