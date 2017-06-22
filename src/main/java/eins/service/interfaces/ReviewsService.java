package eins.service.interfaces;

import eins.entity.Reviews;

import java.util.List;

public interface ReviewsService {

    void save(Reviews o);

    Reviews findOne(int id);

    List<Reviews> findAll();

}
