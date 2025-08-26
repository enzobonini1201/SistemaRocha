
package com.exemplo.login.service;

import com.exemplo.login.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean validarLogin(String email, String senha) {
        return usuarios.stream()
                .anyMatch(user -> user.getEmail().equals(email) && user.getSenha().equals(senha));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
