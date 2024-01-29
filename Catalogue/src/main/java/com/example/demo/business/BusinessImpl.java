package com.example.demo.business;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repos.ICategorie;
import com.example.demo.repos.IProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessImpl implements IBusiness{
    @Autowired
    ICategorie crepo;
    @Autowired
    IProduit cprod;

    @Override
    public Categorie addcat(Categorie c) {
        return crepo.save(c);
    }

    @Override
    public List<Categorie> allcat() {
        return crepo.findAll();
    }

    @Override
    public Categorie findCat(long idcat)
    {
        return crepo.findById(idcat).orElseThrow();
    }

    @Override
    public Produit addProduit(Produit p, long idcat) {
        Categorie c=crepo.findById(idcat).orElseThrow();
        p.setCategorie(c);
        p=cprod.save(p);
        return p;

    }

    @Override
    public Produit findProduitById(long idpr) {

        return cprod.findById(idpr).orElseThrow();
    }

    @Override
    public List<Produit> findProduitByCat(long idcat) {
        return cprod.findByCategorieId(idcat);
    }

    @Override
    public List<Produit> findbetweenprix(int min, int max) {
        return cprod.findByPrixBetween(min,max);
    }

    @Override
    public List<Produit> findLessqte(int seuil) {
        return cprod.findByQuantiteLessThan(seuil);
    }
}
