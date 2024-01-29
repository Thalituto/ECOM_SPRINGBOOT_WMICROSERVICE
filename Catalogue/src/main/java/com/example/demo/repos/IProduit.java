package com.example.demo.repos;

import com.example.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProduit extends JpaRepository<Produit,Long> {
    public List<Produit> findByPrixBetween(double min, double max);
    public List<Produit>findByQuantiteLessThan(int seuil);
    public List<Produit>findByCategorieId(long id);

}
