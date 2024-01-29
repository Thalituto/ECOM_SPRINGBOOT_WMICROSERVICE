package com.example.demo.repos;

import com.example.demo.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategorie extends JpaRepository<Categorie,Long> {

}
