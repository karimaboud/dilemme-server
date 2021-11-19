package fr.uga.miage.m1.dilemme_g1_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dilemme_g1_1.dao.JeuRepository;
import fr.uga.miage.m1.dilemme_g1_1.model.Jeu;

@Service
public class JeuService {

  @Autowired
  private JeuRepository jeuRepository;

  public Jeu createJeu(Jeu jeu) {
    return jeuRepository.save(jeu);
  }

  public Jeu getJeu(int id) {
    return jeuRepository.findById(id).get();
  }

  public List<Jeu> getJeux() {
    return jeuRepository.findAll();
  }

  public void deleteJeux() {
    jeuRepository.deleteAll();
  }

  public Jeu updateJeu(Jeu jeu) {
    return jeuRepository.save(jeu);
  }

}
