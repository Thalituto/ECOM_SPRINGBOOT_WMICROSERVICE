package com.example.commande.services;

import com.example.commande.entities.Commande;
import com.example.commande.entities.Lignecommande;

import java.util.List;

public interface IOrder {



    public Commande addCommande(Commande c);
    public List<Commande>allCommandes();
    public List<Commande>allCommandesById(long idclient);
    public Commande findCommandeByidc(long idc);
    public Commande findCommandeByid2(long idc);

    public Lignecommande addLigne(Lignecommande lg,long idc);
    public Commande update(long idc,Commande c);
    public Commande deleteLigneCoammnde(long idl);



}
