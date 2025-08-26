package com.rochatransportes.controller;

import com.rochatransportes.model.Nota;
import com.rochatransportes.repository.NotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nota")
public class NotaController {
    private final NotaRepository repository;

    public NotaController(NotaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        List<Nota> list = repository.findAll();
        model.addAttribute("list", list);
        return "nota-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("nota", new Nota());
        return "nota-form";
    }

    @PostMapping
    public String save(@ModelAttribute Nota nota) {
        repository.save(nota);
        return "redirect:/nota";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Nota obj = repository.findById(id).orElseThrow();
        model.addAttribute("nota", obj);
        return "nota-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Nota nota) {
        repository.save(nota);
        return "redirect:/nota";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/nota";
    }
}
