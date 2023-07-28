package domian;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Orders.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();
        System.out.println("Enter the Id");
        int id= sc.nextInt();

        Customer c1=ses.get(Customer.class,id);

        Orders ord1=new Orders();
        ord1.setOrderNo("ORD03");
        ord1.setOrderAmount(3000.0);

        c1.placeOrder(ord1);
        tx=ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("place order successfully");
    }
}
