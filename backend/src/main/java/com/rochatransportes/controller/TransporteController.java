package com.rochatransportes.controller;

import com.rochatransportes.model.Transporte;
import com.rochatransportes.repository.TransporteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transporte")
public class TransporteController {
    private final TransporteRepository repository;

    public TransporteController(TransporteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        List<Transporte> list = repository.findAll();
        model.addAttribute("list", list);
        return "transporte-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("transporte", new Transporte());
        return "transporte-form";
    }

    @PostMapping
    public String save(@ModelAttribute Transporte transporte) {
        repository.save(transporte);
        return "redirect:/transporte";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Transporte obj = repository.findById(id).orElseThrow();
        model.addAttribute("transporte", obj);
        return "transporte-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Transporte transporte) {
        repository.save(transporte);
        return "redirect:/transporte";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/transporte";
    }
}
