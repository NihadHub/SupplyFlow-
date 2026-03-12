package org.example.supplyflow.model;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy  =GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String categorie;
    private double prix;
    private int quantite;

    @ManyToOne
    @JoinColumn(name="fornisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private List<MouvementStock> mouvements;


    public Produit() {
    }

    public Produit(String nom, String categorie, double prix, int quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<MouvementStock> getMouvements() {
        return mouvements;
    }

    public void setMouvements(List<MouvementStock> mouvements) {
        this.mouvements = mouvements;
    }

}
