package fr.uga.miage.m1.dilemme_g1_1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dilemme_g1_1.model.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
}