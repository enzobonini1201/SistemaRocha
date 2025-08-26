
package com.exemplo.login.controller;

import com.exemplo.login.model.Usuario;
import com.exemplo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastro")
@CrossOrigin(origins = "*")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String cadastrar(@RequestBody Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return "Usuário cadastrado com sucesso!";
    }
}
