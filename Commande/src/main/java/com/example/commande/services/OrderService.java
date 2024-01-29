package com.example.commande.services;

import com.example.commande.Api.IClient;
import com.example.commande.entities.Client;
import com.example.commande.entities.Commande;
import com.example.commande.entities.Lignecommande;
import com.example.commande.repos.ICommande;
import com.example.commande.repos.ILigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrder{
    @Autowired
    ICommande crepo;
    @Autowired
    ILigneCommande lrepo ;
    @Autowired
    IClient clientFeign;

    @Override
    public Commande addCommande(Commande c) {
        return crepo.save(c);
    }

    @Override
    public List<Commande> allCommandes() {
        return crepo.findAll();
    }

    @Override
    public List<Commande> allCommandesById(long idclient) {
        return crepo.findByidclient(idclient);
    }

    @Override
    public Commande findCommandeByidc(long idc) {
        Commande c=crepo.findById(idc).orElseThrow();
        Client client=clientFeign.findById(c.getIdclient());
        c.setClient(client);

        return c;
    }
    @Override
    public Commande findCommandeByid2(long idc) {
        Commande c=crepo.findById(idc).orElseThrow();
        Client client=clientFeign.findById(c.getIdclient());
        c.setClient(client);

        return c;
    }


    @Override
    public Lignecommande addLigne(Lignecommande lg, long idc) {
        Commande c=crepo.findById(idc).orElseThrow();
        lg.setCommande(c);
        lg=lrepo.save(lg);
        return lg;
    }

    @Override
    public Commande update(long idc, Commande c) {
        Commande ct=crepo.findById(idc).orElseThrow();
        ct.setDate(c.getDate());
        ct.setIdclient(c.getIdclient());
        ct.setId(c.getId());
        ct.setAdresse(c.getAdresse());
        crepo.save(ct);

        return ct;
    }

    @Override
    public Commande deleteLigneCoammnde(long idl) {
        Lignecommande lg=lrepo.findById(idl).orElseThrow();
        Commande c=lg.getCommande();
        lrepo.delete(lg);
        Commande cm=crepo.findById(c.getId()).orElseThrow();

        return cm;
    }
}
