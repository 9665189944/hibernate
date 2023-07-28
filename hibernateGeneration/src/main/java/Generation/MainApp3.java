package Generation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp3 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Book3.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Book3 b=new Book3();
        b.setProductName("Mobile");
        b.setProductPrice(20000.0);
        tx= ses.beginTransaction();
        ses.save(b);
        tx.commit();
        System.out.println("Product Insert Successfully");

    }
}
