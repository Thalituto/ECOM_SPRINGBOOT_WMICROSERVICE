package com.example.commande.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lignecommande {
    @Id
    @GeneratedValue
    long Id;
    double prix;
    int quantite;

    @ManyToOne
    @JsonIgnore
    Commande commande;

    long idproduit;
    @Transient
    Produit produit;

}