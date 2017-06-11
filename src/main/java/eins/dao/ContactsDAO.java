package eins.dao;

import eins.entity.Contacts;
import eins.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsDAO  extends JpaRepository<Contacts,Integer> {

}
