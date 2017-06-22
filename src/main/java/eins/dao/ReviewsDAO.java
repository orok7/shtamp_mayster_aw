package eins.dao;

import eins.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsDAO extends JpaRepository<Reviews,Integer> {


}