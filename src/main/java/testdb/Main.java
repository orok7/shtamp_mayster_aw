package testdb;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        String isCompanyStr = null;
        String userEmail = "petro@gmail.com";
        String userPassword = "1234";
        String userPassAgain = "1234";
        String userName = "Петро";
        String userSurname = "Петрів";
        String userForm = "";
        String userFullName = "";
        String userShortName = "";
        String userCode = "";
        String userContactName = "";
        String userContactSurname = "";
        boolean isCompany = (isCompanyStr == null)?false:true;

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Carrier.class)
                .addAnnotatedClass(CarrierDepartment.class)
                .addAnnotatedClass(Characteristic.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(CompanyUser.class)
                .addAnnotatedClass(Contacts.class)
                .addAnnotatedClass(Delivery.class)
                .addAnnotatedClass(ProductGroup.class)
                .addAnnotatedClass(Image.class)
                .addAnnotatedClass(IndividualUser.class)
                .addAnnotatedClass(MeasurementUnits.class)
                .addAnnotatedClass(Invoice.class)
                .addAnnotatedClass(InvoiceStatus.class)
                .addAnnotatedClass(PaymentType.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductToBuy.class)
                .addAnnotatedClass(Property.class)
                .addAnnotatedClass(PropertyValue.class)
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(Reviews.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        User user;
        if (isCompany) {
            CompanyUser cu = new CompanyUser(0,userForm,userFullName,userShortName,userCode);
            Contacts contacts = new Contacts(userContactName,userContactSurname);
            user = new User(userEmail,userPassword,isCompany,cu,null, contacts);
            session.save(cu);
            session.save(contacts);
            session.save(user);
        } else {
            IndividualUser iu = new IndividualUser(0,userName,userSurname);
            Contacts contacts = new Contacts(userName,userSurname);
            user = new User(userEmail,userPassword,isCompany,null,iu, contacts);
            session.save(iu);
            session.save(contacts);
            session.save(user);
        }

        session.getTransaction().commit();
        session.close();
        factory.close();

    }

}
