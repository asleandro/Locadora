package com.example.locadora;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.locadora.fragmentos.CarrinhoFragment;
import com.example.locadora.fragmentos.FerramentasFragment;
import com.example.locadora.fragmentos.HomeFragment;
import com.example.locadora.fragmentos.LoginFragment;
import com.example.locadora.model.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;
    Usuario usuario = new Usuario();

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
                selectedFragment = new CarrinhoFragment();
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