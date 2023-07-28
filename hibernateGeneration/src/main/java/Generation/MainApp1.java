package Generation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp1 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Book1.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

         Book1 b=new Book1();
         b.setProductName("java");
         b.setProductPrice(2000.0);
        tx= ses.beginTransaction();
        ses.save(b);
        tx.commit();
        System.out.println("Product Insert Successfully");

    }
}
