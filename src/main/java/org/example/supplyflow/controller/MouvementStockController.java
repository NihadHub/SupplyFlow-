package org.example.supplyflow.controller;

import org.example.supplyflow.model.MouvementStock;
import org.example.supplyflow.model.Produit;
import org.example.supplyflow.repository.MouvementStockRepository;
import org.example.supplyflow.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/mouvements")
public class MouvementStockController {

    @Autowired
    private MouvementStockRepository mouvementRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public String listMouvements(Model model) {
        model.addAttribute("mouvements", mouvementRepository.findAll());
        return "mouvements/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("mouvement", new MouvementStock());
        model.addAttribute("produits", produitRepository.findAll());
        return "mouvements/add";
    }

    @PostMapping("/save")
    public String saveMouvement(@RequestParam Long produitId,
                                @RequestParam String type,
                                @RequestParam int quantite) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        if (type.equals("ENTREE")) {
            produit.setQuantite(produit.getQuantite() + quantite);
        } else if (type.equals("SORTIE")) {
            if (produit.getQuantite() < quantite) {
                return "redirect:/mouvements/add?error=stock_insuffisant";

            }
            produit.setQuantite(produit.getQuantite() - quantite);
        }
        produitRepository.save(produit);
        MouvementStock mouvement = new MouvementStock();
        mouvement.setType(type);
        mouvement.setQuantite(quantite);
        mouvement.setDate(LocalDateTime.now());
        mouvement.setProduit(produit);

        mouvementRepository.save(mouvement);
        return "redirect:/mouvements";

    }





































}