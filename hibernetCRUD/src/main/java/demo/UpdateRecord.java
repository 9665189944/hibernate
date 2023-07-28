package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateRecord {
    static Configuration cfg;
    static SessionFactory factory;
    static Session ses;
    static Transaction tx;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        int id = sc.nextInt();


        cfg = new Configuration();
        cfg = cfg.configure();
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Product p = ses.get(Product.class, id);
           p.setProductPrice(40009.8);

        tx = ses.beginTransaction();
        ses.update(p);
        tx.commit();
        System.out.println("Product update Successfully");

    }

}
