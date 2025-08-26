package com.rochatransportes.controller;

import com.rochatransportes.model.Motorista;
import com.rochatransportes.repository.MotoristaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/motorista")
public class MotoristaController {
    private final MotoristaRepository repository;

    public MotoristaController(MotoristaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        List<Motorista> list = repository.findAll();
        model.addAttribute("list", list);
        return "motorista-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("motorista", new Motorista());
        return "motorista-form";
    }

    @PostMapping
    public String save(@ModelAttribute Motorista motorista) {
        repository.save(motorista);
        return "redirect:/motorista";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Motorista obj = repository.findById(id).orElseThrow();
        model.addAttribute("motorista", obj);
        return "motorista-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Motorista motorista) {
        repository.save(motorista);
        return "redirect:/motorista";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/motorista";
    }
}
