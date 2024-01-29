package com.example.demo.business;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

import java.util.List;
public interface IBusiness {
    public Categorie addcat(Categorie c);
    public List<Categorie>allcat();
    public Categorie findCat(long idcat);
    public Produit addProduit(Produit p, long idcat);
    public Produit findProduitById(long idpr);
    public List<Produit>findProduitByCat(long idcat);
    public List<Produit>findbetweenprix(int min,int max);
    public List<Produit>findLessqte(int seuil);



}
