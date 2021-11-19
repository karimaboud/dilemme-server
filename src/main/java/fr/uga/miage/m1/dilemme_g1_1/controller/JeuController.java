package fr.uga.miage.m1.dilemme_g1_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dilemme_g1_1.model.Jeu;
import fr.uga.miage.m1.dilemme_g1_1.services.JeuService;

@RestController
@CrossOrigin(origins = "*")
public class JeuController {

  @Autowired
  private JeuService jeuService;

  @PostMapping("/addJeu")
  public synchronized Jeu createJeu(@RequestBody Jeu jeu) throws InterruptedException {
    Jeu j = jeuService.createJeu(jeu);
    boolean b = false;
    while (!b) {
      // System.out.println("Waiting...");
      // System.out.println("BECAUSE idJoueur1= " +
      // jeuService.getJeu(jeu.getId()).getIdJoueur1());
      // System.out.println("AND idJoueur2=" +
      // jeuService.getJeu(jeu.getId()).getIdJoueur2());
      wait();
      b = true;
    }
    return j;
  }

  @GetMapping("/jeu/{id}")
  public Jeu getJeu(@PathVariable("id") int id) {
    return jeuService.getJeu(id);
  }

  @GetMapping("/jeux")
  public List<Jeu> getJeux() {
    return jeuService.getJeux();
  }

  @PutMapping("/update")
  public synchronized Jeu updateJeu(@RequestBody Jeu jeu) {
    Jeu j = jeuService.updateJeu(jeu);
    if (jeuService.getJeu(jeu.getId()).getIdJoueur1() > 0 && jeuService.getJeu(jeu.getId()).getIdJoueur2() > 0) {
      // System.out.println("Wake up !");
      // System.out.println("BECAUSE idJoueur1= " +
      // jeuService.getJeu(jeu.getId()).getIdJoueur1());
      // System.out.println("AND idJoueur2=" +
      // jeuService.getJeu(jeu.getId()).getIdJoueur2());
      notify();
    }
    return j;
  }

  @DeleteMapping("/deleteJeux")
  public void deleteJeux() {
    jeuService.deleteJeux();
  }

}
