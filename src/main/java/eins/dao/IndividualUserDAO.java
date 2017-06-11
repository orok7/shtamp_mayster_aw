package eins.dao;

import eins.entity.IndividualUser;
import eins.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualUserDAO  extends JpaRepository<IndividualUser,Integer> {

}
