package com.example.commande.repos;

import com.example.commande.entities.Lignecommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ILigneCommande extends JpaRepository<Lignecommande,Long> {

}
