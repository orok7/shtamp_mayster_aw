package eins.service.interfaces;

import eins.entity.Rating;

import java.util.List;

public interface RatingService {

    void save(Rating o);

    Rating findOne(int id);

    List<Rating> findAll();

}
