package eins.service.impl;

import eins.dao.ImageDAO;
import eins.entity.Image;
import eins.service.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDAO dbDAO;

    @Override
    public void save(Image o) {
        dbDAO.save(o);
    }

    @Override
    public Image findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Image> findAll() {
        return dbDAO.findAll();
    }
}