package com.example.locadora.model;

import java.util.List;

public class BancoUsuarios {
    private static List<Usuario> usuarios;

    public void adiciona(Usuario usuario){
        usuarios.add(usuario);
    }

}
