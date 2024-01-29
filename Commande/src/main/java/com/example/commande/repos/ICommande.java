package com.example.commande.repos;

import com.example.commande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
@EnableJpaRepositories
public interface ICommande extends JpaRepository<Commande,Long> {
 public List<Commande>findByDateBetween(LocalDate dd,LocalDate df);
 public List<Commande>findByidclient(long id);

}
