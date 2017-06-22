package eins.dao;

import eins.entity.ProductToBuy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductToBuyDAO extends JpaRepository<ProductToBuy,Integer> {


}
