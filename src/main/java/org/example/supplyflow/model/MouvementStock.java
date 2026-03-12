package org.example.supplyflow.model;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
public class MouvementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private int quantite;
    private LocalDateTime date;

    @Setter
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    public MouvementStock() {
    }

    public MouvementStock(String type, int quantite, LocalDateTime date, Produit produit) {
        this.type = type;
        this.quantite = quantite;
        this.date = date;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Produit getProduit() {
        return produit;}

}
