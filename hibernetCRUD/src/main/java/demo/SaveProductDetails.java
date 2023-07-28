package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProductDetails {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        //Step-1 Activate hibernate framework
        cfg=new Configuration();
        //Step-2 Read data from cfg.xml file
        cfg=cfg.configure();
        //Step-3 Establish connection with database
        factory=cfg.buildSessionFactory();
        //Step-4 Start the session with database
        ses= factory.openSession();
        //Step-5 Create an object of domain class
        Product p1=new Product();
        p1.setProductId(1);
        p1.setProductName("Mobile");
        p1.setProductPrice(15000.30);
        p1.setProductCatagory("GADGETs");
        //Step-6 Start the transaction
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Insert Successfully");

    }
}
