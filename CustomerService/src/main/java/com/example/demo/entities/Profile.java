package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Profile {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	long id;
	
	String nom;
	
	String[] prenoms;
	@Enumerated(EnumType.STRING)
	Gender gender;
	@Embedded
	Adresse adresse;
	@JsonIgnore
	@OneToOne(mappedBy = "profile")
	Account account;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[] getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String[] prenoms) {
		this.prenoms = prenoms;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
}
