package eins.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DbDAO <T> extends JpaRepository<T,Integer> {

}
