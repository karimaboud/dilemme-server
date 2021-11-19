package fr.uga.miage.m1.dilemme_g1_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jeu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  int idJoueur1;
  int idJoueur2;
}
