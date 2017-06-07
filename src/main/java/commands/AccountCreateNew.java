package commands;

import entity.*;
import exceptions.SMDBException;
import interfaces.Command;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountCreateNew implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SMDBException {
        String isCompanyStr = request.getParameter("isCompany");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String userPassAgain = request.getParameter("userPassAgain");
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String userForm = request.getParameter("userForm");
        String userFullName = request.getParameter("userFullName");
        String userShortName = request.getParameter("userShortName");
        String userCode = request.getParameter("userCode");
        String userContactName = request.getParameter("userContactName");
        String userContactSurname = request.getParameter("userContactSurname");
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
