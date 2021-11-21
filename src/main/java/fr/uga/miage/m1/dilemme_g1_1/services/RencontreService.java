package fr.uga.miage.m1.dilemme_g1_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dilemme_g1_1.dao.RencontreRepository;
import fr.uga.miage.m1.dilemme_g1_1.model.Rencontre;

@Service
public class RencontreService {

  @Autowired
  private RencontreRepository rencontreRepository;

  public Rencontre createRencontre(Rencontre rencontre) {
    return rencontreRepository.save(rencontre);
  }

  public Rencontre getRencontre(int id) {
    return rencontreRepository.findById(id).get();
  }

  public List<Rencontre> getRencontres() {
    return rencontreRepository.findAll();
  }

  public void deleteRencontres() {
    rencontreRepository.deleteAll();
  }

  public Rencontre updateRencontre(Rencontre rencontre) {
    return rencontreRepository.save(rencontre);
  }

}
