package HQL;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class displayroww {
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


        Criteria crt1= ses.createCriteria(Product.class);
        crt1.setMaxResults(1);
        List<Product> data1=crt1.list();
        for (Product p:data1
             ) {
            System.out.println(p);
        }

        System.out.println("================================");

        Criteria crt2= ses.createCriteria(Product.class);
        crt2.setFirstResult(1);
        List<Product> data2=crt2.list();
        for (Product p:data2
        ) {
            System.out.println(p);
        }
    }

}
