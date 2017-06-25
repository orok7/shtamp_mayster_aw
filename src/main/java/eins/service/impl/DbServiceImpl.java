package eins.service.impl;

import eins.dao.*;
import eins.entity.*;
import eins.service.interfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class DbServiceImpl implements DbService {

    @Override
    public void save(Object o, Class<?> clazz) {
        initMyDAOMap();
        dbDAO.get(clazz).save(o);
    }

    @Override
    public List<Object> findAll(Class<?> clazz) {
        initMyDAOMap();
        return dbDAO.get(clazz).findAll();
    }



    ////////////////////////////////////////////////////////////////////////


    
    @Autowired private AddressDAO addressDAO;
    @Autowired private CarrierDAO carrierDAO;
    @Autowired private CarrierDepartmentDAO carrierDepartmentDAO;
    @Autowired private CharacteristicDAO characteristicDAO;
    @Autowired private CityDAO cityDAO;
    @Autowired private CompanyUserDAO companyUserDAO;
    @Autowired private ContactsDAO contactsDAO;
    @Autowired private DeliveryDAO deliveryDAO;
    @Autowired private ImageDAO imageDAO;
    @Autowired private IndividualUserDAO iuDAO;
    @Autowired private InvoiceDAO invoiceDAO;
    @Autowired private InvoiceStatusDAO invoiceStatusDAO;
    @Autowired private MeasurementUnitsDAO measurementUnitsDAO;
    @Autowired private PaymentTypeDAO paymentTypeDAO;
    @Autowired private ProductGroupDAO productGroupDAO;
    @Autowired private ProductDAO productDAO;
    @Autowired private ProductToBuyDAO productToBuyDAO;
    @Autowired private PropertyDAO propertyDAO;
    @Autowired private PropertyValueDAO propertyValueDAO;
    @Autowired private RatingDAO ratingDAO;
    @Autowired private ReviewsDAO reviewsDAO;
    @Autowired private UserDAO uDAO;

    private Map<Class<?>, JpaRepository> dbDAO = new HashMap<>();

    private void initMyDAOMap(){
        dbDAO.put(Address.class, addressDAO);
        dbDAO.put(Carrier.class, carrierDAO); 
        dbDAO.put(CarrierDepartment.class, carrierDepartmentDAO); 
        dbDAO.put(Characteristic.class, characteristicDAO); 
        dbDAO.put(City.class, cityDAO); 
        dbDAO.put(CompanyUser.class, companyUserDAO); 
        dbDAO.put(Contacts.class, contactsDAO); 
        dbDAO.put(Delivery.class, deliveryDAO); 
        dbDAO.put(Image.class, imageDAO); 
        dbDAO.put(IndividualUser.class, iuDAO); 
        dbDAO.put(Invoice.class, invoiceDAO); 
        dbDAO.put(InvoiceStatus.class, invoiceStatusDAO); 
        dbDAO.put(MeasurementUnits.class, measurementUnitsDAO); 
        dbDAO.put(PaymentType.class, paymentTypeDAO); 
        dbDAO.put(ProductGroup.class, productGroupDAO); 
        dbDAO.put(Product.class, productDAO); 
        dbDAO.put(ProductToBuy.class, productToBuyDAO); 
        dbDAO.put(Property.class, propertyDAO); 
        dbDAO.put(PropertyValue.class, propertyValueDAO); 
        dbDAO.put(Rating.class, ratingDAO); 
        dbDAO.put(Reviews.class, reviewsDAO); 
        dbDAO.put(User.class, uDAO); 
    }
}
