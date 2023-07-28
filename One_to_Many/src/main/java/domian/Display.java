package domian;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Display {
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
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

        System.out.println("Enter the id");
        int id=sc.nextInt();

        Customer c1=ses.get(Customer.class,id);
        if(c1!=null)
        {
            System.out.println("Name "+c1.getCustomerName());
            System.out.println("Contact "+c1.getCustomerContact());
            List<Orders> orderList=c1.getOrderList();
            for(Orders o:orderList)
            {
                System.out.println("Order NO "+o.getOrderNo());
                System.out.println("CART AMT "+o.getOrderAmount());
            }
        }else {
            System.out.println("Invalid ID");
        }

    }
}
