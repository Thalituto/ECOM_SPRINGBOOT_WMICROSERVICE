package com.example.commande.Api;

import com.example.commande.entities.Client;
import com.example.commande.entities.Commande;
import com.example.commande.entities.Lignecommande;
import com.example.commande.services.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/api/commande")
public class OrderAPI {
@Autowired
IOrder service;
@Autowired
IClient clientFeign;

@Autowired
IProduit serviceProduit;

@Autowired
    KafkaTemplate<String,String>kafka;

@GetMapping("/kfka/{msg}")
public String send(@PathVariable String msg){
    kafka.send("estore-events",msg);
    return "ok";
}


    @GetMapping("/commandes")
    public List<Commande> allCommandes() {
        return service.allCommandes();
    }
    @PostMapping("/commandes")
    public Commande addCommande(@RequestBody Commande c) {
        c.setDate(LocalDate.now());
        c= service.addCommande(c);

        return c;
    }



    @GetMapping("/commandes/{idc}")
    public Commande findCommandeByidc(@PathVariable long idc){

        Commande c=service.findCommandeByidc(idc);
        kafka.send("order-events","idclient:"+c.getIdclient()+"vers la topic order-events");
        Client cl=clientFeign.findById(c.getIdclient());
        c.setClient(cl);
        //c.getLignes().forEach(l->l.setProduit(serviceProduit.findProduitById(l.getIdproduit())));
        c.getLignes().forEach(l->l.setProduit(serviceProduit.findProduitById(l.getIdproduit())));
        return c;

    }
    @PostMapping("/commandes/{idc}/ligneCommandes")
 public Commande addLigne(@RequestBody Lignecommande lg,@PathVariable long idc){

        lg=service.addLigne(lg,idc);
        Commande c= lg.getCommande();
        return  c;
 }
 @GetMapping("/clients/{clientId}")
public Client getClient(@PathVariable long clientId){
      Client client =clientFeign.findById(clientId);

        return client;
}

}
