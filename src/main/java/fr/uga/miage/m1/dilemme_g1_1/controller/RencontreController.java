package fr.uga.miage.m1.dilemme_g1_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dilemme_g1_1.model.Rencontre;
import fr.uga.miage.m1.dilemme_g1_1.services.RencontreService;

@RestController
@CrossOrigin(origins = "*")
public class RencontreController {

  @Autowired
  private RencontreService rencontreService;

  @PostMapping("/createRencontre")
  public synchronized Rencontre createRencontre(@RequestBody Rencontre rencontre) throws InterruptedException {
    Rencontre renc = rencontreService.createRencontre(rencontre);
    boolean b = false;
    while (!b) {
      System.out.println("Waiting...");
      wait();
      b = true;
    }
    return renc;
  }

  @GetMapping("/rencontres")
  public List<Rencontre> getRencontres() {
    return rencontreService.getRencontres();
  }

  @GetMapping("/rencontre/{id}")
  public Rencontre getRencontre(@PathVariable int id) {
    return rencontreService.getRencontre(id);
  }

  @PutMapping("/updateRencontre")
  public synchronized Rencontre updateRencontre(@RequestBody Rencontre rencontre) {
    // rencontre.getGagnant()
    Rencontre renc = rencontreService.updateRencontre(rencontre);
    if (rencontreService.getRencontre(renc.getId()).getJoueurs().size() == 2) {
      System.out.println("Notified !");
      notify();
    }
    return renc;
  }

}
