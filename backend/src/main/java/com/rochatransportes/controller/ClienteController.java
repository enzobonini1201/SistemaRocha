package com.rochatransportes.controller;

import com.rochatransportes.model.Cliente;
import com.rochatransportes.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        List<Cliente> list = repository.findAll();
        model.addAttribute("list", list);
        return "cliente-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @PostMapping
    public String save(@ModelAttribute Cliente cliente) {
        repository.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Cliente obj = repository.findById(id).orElseThrow();
        model.addAttribute("cliente", obj);
        return "cliente-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Cliente cliente) {
        repository.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/cliente";
    }
}
