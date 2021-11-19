package fr.uga.miage.m1.dilemme_g1_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dilemme_g1_1.model.Joueur;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.uga.miage.m1.dilemme_g1_1.services.JoueurService;

@RestController
@CrossOrigin(origins = "*")

public class JoueurController {

  @Autowired
  private JoueurService joueurService;

  @PostMapping("/addJoueur")
  public Joueur addJoueur(@RequestBody Joueur joueur) {
    if (!joueur.getNom().isEmpty()) {
      return joueurService.createJoueur(joueur);
    } else {
      return null;
    }

  }

  @PostMapping("/addJoueurs")
  public List<Joueur> addJoueurs(@RequestBody List<Joueur> joueurs) {
    return joueurService.createJoueurs(joueurs);
  }

  @GetMapping("/joueur/{id}")
  public Joueur getJoueurById(@PathVariable int id) {
    return joueurService.getJoueurById(id);
  }

  @GetMapping("/joueurs")
  public List<Joueur> getAllJoueurs() {
    return joueurService.getJoueurs();
  }

  @DeleteMapping("/deleteJoueur/{id}")
  public void deleteJoueur(@PathVariable("id") int id) {
    joueurService.deleteUserById(id);
  }

  @DeleteMapping("/deleteJoueurs")
  public void deleteJoueurs() {
    this.joueurService.deleteAll();
  }

}