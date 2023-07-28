package Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddDataTable {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        //Step-1 Activate hibernate framework
        cfg=new Configuration();
        //Step-2 Read data from cfg.xml file
        cfg=cfg.configure();
        //step-3 Call AnnotatedClass Method
        cfg=cfg.addAnnotatedClass(Product.class);
        //Step-4 Establish connection with database
        factory=cfg.buildSessionFactory();
        //Step-5 Start the session with database
        ses= factory.openSession();
        //Step-6 Create an object of domain class

        Product p1=new Product(3,"Laptop",2000.0,"GAGDATE");

        //Step-7 Start the transaction
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Insert Successfully");

    }
}
