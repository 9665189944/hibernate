package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SaveDynamicValue {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
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

        System.out.println("Enter the id");
        int id=sc.nextInt();
        System.out.println("Enter the Product name");
        String name=sc.next();
        System.out.println("Enter the Product Price");
        double price=sc.nextDouble();
        System.out.println("Enter the Product Category");
        String category=sc.next();

        Product p1=new Product();
        p1.setProductId(id);
        p1.setProductName(name);
        p1.setProductPrice(price);
        p1.setProductCatagory(category);

        //Step-6 Start the transaction
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Insert Successfully");

    }
}
