package fr.uga.miage.m1.dilemme_g1_1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Rencontre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  int nbTours;
  @ElementCollection
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  List<Joueur> joueurs;

  @ElementCollection
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  List<Tour> tours;
  int scoreJoueur1 = 0;
  int scoreJoueur2 = 0;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  Joueur gagnant = new Joueur();

  public void calculeScoreJ1() {
    for (Tour t : tours) {
      this.scoreJoueur1 = this.scoreJoueur1 + t.getPointsJoueur1();
    }
  }

  public void calculScoreJ2() {
    for (Tour t : tours) {
      this.scoreJoueur2 = this.scoreJoueur2 + t.getPointsJoueur2();
    }
  }

  public Joueur calculeGagnant() {
    this.calculScoreJ2();
    this.calculScoreJ2();
    System.out.println("score j1=" + scoreJoueur1);
    System.out.println("score j2=" + scoreJoueur2);

    if (scoreJoueur1 > scoreJoueur2) {
      return joueurs.get(0);
    } else if (scoreJoueur2 > scoreJoueur1) {
      return joueurs.get(1);
    } else {
      return null;
    }

  }

}
