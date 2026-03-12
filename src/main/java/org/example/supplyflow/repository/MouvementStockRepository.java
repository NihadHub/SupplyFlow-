package org.example.supplyflow.repository;
import org.example.supplyflow.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<MouvementStock,Long> {
}

