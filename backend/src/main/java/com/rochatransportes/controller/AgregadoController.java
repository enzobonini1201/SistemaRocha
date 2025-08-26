package com.rochatransportes.controller;

import com.rochatransportes.model.Agregado;
import com.rochatransportes.repository.AgregadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agregado")
public class AgregadoController {
    private final AgregadoRepository repository;

    public AgregadoController(AgregadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String list(Model model) {
        List<Agregado> list = repository.findAll();
        model.addAttribute("list", list);
        return "agregado-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("agregado", new Agregado());
        return "agregado-form";
    }

    @PostMapping
    public String save(@ModelAttribute Agregado agregado) {
        repository.save(agregado);
        return "redirect:/agregado";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Agregado obj = repository.findById(id).orElseThrow();
        model.addAttribute("agregado", obj);
        return "agregado-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Agregado agregado) {
        repository.save(agregado);
        return "redirect:/agregado";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/agregado";
    }
}
