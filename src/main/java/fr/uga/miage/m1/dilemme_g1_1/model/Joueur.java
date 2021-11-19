package fr.uga.miage.m1.dilemme_g1_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.uga.miage.m1.dilemme_g1_1.strategies.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joueur {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int idJoueur;
  String nom;
  boolean peutJouer;
  boolean abandon;
  int score;
  Action derniereAction;

}
