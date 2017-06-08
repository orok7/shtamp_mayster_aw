package eins.dao.interfaces;

import eins.entity.CompanyUser;
import eins.entity.User;

import java.util.List;

public interface CompanyUserDAO {

    void save(CompanyUser companyUser);

    CompanyUser findById(int id);

    List<CompanyUser> findAll();

}
