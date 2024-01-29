package com.example.commande.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @CreatedDate
    LocalDate date;
    @Embedded
    Adresse adresse;
    @Enumerated(EnumType.STRING)
    State state;
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "commande")
    List<Lignecommande>lignes;
    long idclient;
    @Transient
    Client client;


    public Commande() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Lignecommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<Lignecommande> lignes) {
        this.lignes = lignes;
    }

    public long getIdclient() {
        return idclient;
    }

    public void setIdclient(long idclient) {
        this.idclient = idclient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
