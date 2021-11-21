package fr.uga.miage.m1.dilemme_g1_1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import fr.uga.miage.m1.dilemme_g1_1.strategies.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Tour {
  @Id
  int id;
  Action actionJoueur1;
  Action actionJoueur2;
  int pointsJoueur1;
  int pointsJoueur2;

  public void calulePoints() {
    if (actionJoueur1 == Action.COOPERER && actionJoueur2 == Action.COOPERER) {
      this.pointsJoueur1 = 3;
      this.pointsJoueur2 = 3;
      System.out.println("C - C");
    } else if (actionJoueur1 == Action.COOPERER && actionJoueur2 == Action.TRAHIR) {
      this.pointsJoueur1 = 0;
      this.pointsJoueur2 = 5;
      System.out.println("C - T");
    } else if (actionJoueur1 == Action.TRAHIR && actionJoueur2 == Action.COOPERER) {
      this.pointsJoueur1 = 5;
      this.pointsJoueur2 = 0;
      System.out.println("T - C");
    } else if (actionJoueur1 == Action.TRAHIR && actionJoueur2 == Action.TRAHIR) {
      this.pointsJoueur1 = 1;
      this.pointsJoueur2 = 1;
      System.out.println("T - T");
    }
  }

}