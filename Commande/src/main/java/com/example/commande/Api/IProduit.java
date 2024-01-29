package com.example.commande.Api;

import com.example.commande.entities.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="catalogue-service")
public interface IProduit {
    @GetMapping("/catalogues/produit/{idpr}")
    public Produit findProduitById(@PathVariable long idpr);
}
