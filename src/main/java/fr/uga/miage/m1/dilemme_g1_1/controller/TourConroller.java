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

import fr.uga.miage.m1.dilemme_g1_1.dao.TourRepository;
import fr.uga.miage.m1.dilemme_g1_1.model.Tour;
import fr.uga.miage.m1.dilemme_g1_1.services.TourService;

@CrossOrigin(origins = "*")
@RestController
public class TourConroller {

  @Autowired
  private TourService tourService;

  @PostMapping("/createTour")
  public synchronized Tour createTour(@RequestBody Tour tour) throws InterruptedException {
    if (tour.getActionJoueur1() == null) {
      System.out.println("Player 2 waiting..");
      tourService.createTour(tour);
      wait();
    } else if (tour.getActionJoueur2() == null) {
      System.out.println("player 1 waiting..");
      tourService.createTour(tour);
      wait();
    }

    Tour t = tourService.createTour(tour);
    return t;
  }

  @GetMapping("/tour/{id}")
  public Tour getTour(@PathVariable("id") int id) {
    return tourService.getTour(id);
  }

  @GetMapping("/tours")
  public List<Tour> getTours() {
    return tourService.getTours();
  }

  @PutMapping("/updateTour")
  public synchronized Tour updateTour(@RequestBody Tour tour) {
    Tour t = tourService.updateTour(tour);
    System.out.println("player notified");
    t.calulePoints();
    tourService.updateTour(t);
    System.out.println(t.toString());
    notify();
    return t;
  }

}
