package org.example.supplyflow.model;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String ville;
    private String telephone;

    @OneToMany(mappedBy = "fournisseur")
    private List<Produit> produits;

    public Fournisseur() {
    }

    public Fournisseur(String nom, String ville, String telephone) {
        this.nom = nom;
        this.ville = ville;
        this.telephone = telephone;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

}
