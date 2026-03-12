package org.example.supplyflow.controller;
import org.example.supplyflow.model.Produit;
import org.example.supplyflow.repository.ProduitRepository;
import org.example.supplyflow.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping
    public String listProduits(Model model){
        model.addAttribute("produits", produitRepository.findAll());
        model.addAttribute("totalProduits", produitRepository.count());
        return "produits/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("produit", new Produit());
        model.addAttribute("fournisseurs", fournisseurRepository.findAll());
        return "produits/add";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute Produit produit){
        produitRepository.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,Model model){
        Produit produit=produitRepository.findById(id).orElseThrow(()-> new RuntimeException("Produit non trouvé"));
        model.addAttribute("produit",produit);
        model.addAttribute("fournisseurs", fournisseurRepository.findAll());
        return "produits/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable Long id){
        produitRepository.deleteById(id);
        return "redirect:/produits";
    }

    @GetMapping("/search")
    public String searchProduit(@RequestParam String nom, Model model){
        model.addAttribute("produits", produitRepository.findByNomContainingIgnoreCase(nom));
        model.addAttribute("totalProduits", produitRepository.count());
        return "produits/list";
    }
}

