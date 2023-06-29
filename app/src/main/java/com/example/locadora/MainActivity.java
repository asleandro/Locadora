package com.example.locadora;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.locadora.adapter.ImagePageAdapter;
import com.example.locadora.fragmentos.CarrinhoFragment;
import com.example.locadora.fragmentos.CarrinhoVazioFragment;
import com.example.locadora.fragmentos.FerramentasFragment;
import com.example.locadora.fragmentos.HomeFragment;
import com.example.locadora.fragmentos.LoginFragment;
import com.example.locadora.model.Produto;
import com.example.locadora.model.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;
    Usuario usuario = new Usuario();
    List<Produto> carrinho = new ArrayList<>();
    ImagePageAdapter imagePageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_home) {
                selectedFragment = new HomeFragment();
            }
            if (item.getItemId() == R.id.menu_ferramentas) {
                selectedFragment = FerramentasFragment.newInstance(usuario);
            }
            if (item.getItemId() == R.id.menu_carrinho) {
                if(usuario.getCarrinho().isEmpty()){
                    selectedFragment = new CarrinhoVazioFragment();
                }
                else selectedFragment = CarrinhoFragment.newInstance(usuario, usuario.getCarrinho());
                //selectedFragment = new CarrinhoFragment();
            }
            if (item.getItemId() == R.id.menu_login) {
                selectedFragment = new LoginFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
            return false;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();

    }

}