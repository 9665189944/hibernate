package HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DisplayAllDataUsingHQL {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Query query=ses.createQuery("select p from Product p");
        List<Product> ProductList=query.list();
        for (Product p:ProductList
             ) {
            System.out.println(p);
        }
        System.out.println("============================================================");

        Query query1=ses.createQuery("select p.productName from Product p");
        List<String> ProductLi=query1.list();
        for (String p1:ProductLi) {
            System.out.println(p1);
        }

//        Query query1=ses.createQuery("select p.productPrice from Product p");
//        List<Double> ProductLi=query1.list();
//        for (Double p1:ProductLi) {
//            System.out.println(p1);
//        }

        Query query2= ses.createQuery("update Product p set p.productPrice=2000.0 where p.productId in (1,2) ");
        tx=ses.beginTransaction();
        int count=query2.executeUpdate();
        tx.commit();
        System.out.println(count+"Updated Record");

        Query query3= ses.createQuery("delete from Product p  where p.productId in (1,2) ");
        tx=ses.beginTransaction();
        int count2=query3.executeUpdate();
        tx.commit();
        System.out.println(count2+"Delete  Record");

    }


}
