package domian;

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
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Orders.class);

        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Customer c1=new Customer();
        c1.setCustomerName("Anuj");
        c1.setCustomerContact(16564);

        Orders ord1=new Orders();
        ord1.setOrderNo("ORD01");
        ord1.setOrderAmount(5000.0);

        Orders ord2=new Orders();
        ord2.setOrderNo("ORD02");
        ord2.setOrderAmount(6000.0);

        //place Order
        c1.placeOrder(ord1);
        c1.placeOrder(ord2);



        tx=ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("place order successfully");
    }
}
