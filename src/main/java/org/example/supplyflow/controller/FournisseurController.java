package org.example.supplyflow.controller;
import org.example.supplyflow.model.Fournisseur;
import org.example.supplyflow.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @GetMapping
    private String listFournisseurs(Model model){
        model.addAttribute("fournisseurs", fournisseurRepository.findAll());
        return "fournisseurs/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("fournisseur", new Fournisseur());
        return "fournisseurs/add";
    }

    @PostMapping("/save")
    public String saveFournisseur(@ModelAttribute Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
        return "redirect:/fournisseurs";
    }
}
