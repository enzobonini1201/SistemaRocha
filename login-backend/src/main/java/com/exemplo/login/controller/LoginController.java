
package com.exemplo.login.controller;

import com.exemplo.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String login(@RequestParam String email, @RequestParam String senha) {
        boolean valido = usuarioService.validarLogin(email, senha);
        if (valido) {
            return "Login bem-sucedido!";
        } else {
            return "Credenciais inválidas.";
        }
    }
}
