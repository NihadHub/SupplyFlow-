package org.example.supplyflow.repository;
import org.example.supplyflow.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomContainingIgnoreCase(String nom);
}
