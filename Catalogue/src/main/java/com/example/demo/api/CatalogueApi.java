package com.example.demo.api;

import com.example.demo.business.IBusiness;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/catalogues")
public class CatalogueApi {
    @Autowired
    IBusiness service;


    @PostMapping("categories")
       public Categorie addcat(@RequestBody Categorie c){
        return service.addcat(c);
    }

@GetMapping("/categories/{idcat}")
public Categorie findCat(@PathVariable long idcat){
  return  service.findCat(idcat);
}

@GetMapping("/categories")
    public List<Categorie> allcat(){
        return service.allcat();
}
@PostMapping("/produits/{idcat}/categories")
public Produit addProduit(@RequestBody Produit p,@PathVariable long idcat){
        return service.addProduit(p,idcat);
}

    @GetMapping("/produit/{idpr}")
    public Produit findProduitById(@PathVariable long idpr)
    {
        return service.findProduitById(idpr);
    }

    @GetMapping("/produits/{idcat}")
    public List<Produit> findProduitByCat(@PathVariable long idcat){
        return service.findProduitByCat(idcat);
    }

}
