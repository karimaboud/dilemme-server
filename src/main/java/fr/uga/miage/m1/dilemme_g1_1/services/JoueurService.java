package fr.uga.miage.m1.dilemme_g1_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dilemme_g1_1.dao.JoueurRepository;
import fr.uga.miage.m1.dilemme_g1_1.model.Joueur;

@Service
public class JoueurService {
  @Autowired
  private JoueurRepository joueurRepository;

  public Joueur createJoueur(Joueur joueur) {
    return joueurRepository.save(joueur);
  }

  public List<Joueur> createJoueurs(List<Joueur> joueurs) {
    return joueurRepository.saveAll(joueurs);
  }

  public Joueur getJoueurById(int id) {
    return joueurRepository.findById(id).get();
  }

  public List<Joueur> getJoueurs() {
    return joueurRepository.findAll();
  }

  public void deleteUserById(int id) {
    this.joueurRepository.deleteById(id);

  }

  public void deleteAll() {
    this.joueurRepository.deleteAll();
  }

}
