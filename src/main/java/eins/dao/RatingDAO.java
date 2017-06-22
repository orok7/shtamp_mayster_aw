package eins.dao;

import eins.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDAO extends JpaRepository<Rating,Integer> {


}