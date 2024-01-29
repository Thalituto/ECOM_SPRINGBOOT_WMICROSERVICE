package com.example.commande.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Adresse {
    String rue,ville,pays;
    int codepostale;

    public Adresse() {
    }

    public Adresse(String rue, String ville, String pays, int codepostale) {
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
        this.codepostale = codepostale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(int codepostale) {
        this.codepostale = codepostale;
    }
}
