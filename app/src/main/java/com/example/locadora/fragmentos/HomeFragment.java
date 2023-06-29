package com.example.locadora.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.locadora.R;
import com.example.locadora.adapter.ImagePageAdapter;

public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private int[] imagens;


    public HomeFragment() {
        // Required empty public constructor
    }

   public static HomeFragment newInstance(ViewPager viewPager) {
        HomeFragment fragment = new HomeFragment();
        fragment.viewPager = viewPager;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        // Inflate the layout for this fragment
        imagens = new int[]{R.drawable.furadeira_impacto, R.drawable.esmerilhadeira, R.drawable.cortador_grama, R.drawable.aparador_cerca_viva};
        ImagePageAdapter adapter = new ImagePageAdapter(requireContext(), imagens, viewPager);


        viewPager.setAdapter(adapter);

        return view;
    }

}