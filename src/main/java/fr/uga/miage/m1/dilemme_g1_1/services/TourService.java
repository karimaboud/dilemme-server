package fr.uga.miage.m1.dilemme_g1_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.dilemme_g1_1.dao.TourRepository;
import fr.uga.miage.m1.dilemme_g1_1.model.Tour;

@Service
public class TourService {

  @Autowired
  TourRepository tourRepository;

  public Tour createTour(Tour tour) {
    return tourRepository.save(tour);
  }

  public Tour getTour(int id) {
    return tourRepository.findById(id).orElse(null);
  }

  public List<Tour> getTours() {
    return tourRepository.findAll();
  }

  public Tour updateTour(Tour tour) {
    return tourRepository.save(tour);
  }

}
