package com.rochatransportes.controller;

import com.rochatransportes.model.Ajudante;
import com.rochatransportes.repository.AjudanteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ajudante")
public class AjudanteController {
    private final AjudanteRepository repository;

    public AjudanteController(AjudanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        List<Ajudante> list = repository.findAll();
        model.addAttribute("list", list);
        return "ajudante-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("ajudante", new Ajudante());
        return "ajudante-form";
    }

    @PostMapping
    public String save(@ModelAttribute Ajudante ajudante) {
        repository.save(ajudante);
        return "redirect:/ajudante";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Ajudante obj = repository.findById(id).orElseThrow();
        model.addAttribute("ajudante", obj);
        return "ajudante-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Ajudante ajudante) {
        repository.save(ajudante);
        return "redirect:/ajudante";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/ajudante";
    }
}
