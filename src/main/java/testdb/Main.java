package testdb;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

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
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        //

        session.getTransaction().commit();
        session.close();
        factory.close();

    }

}
