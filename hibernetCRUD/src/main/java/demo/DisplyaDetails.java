package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Scanner;

public class DisplyaDetails {

    static Configuration cfg;
    static SessionFactory factory;
   static Session ses;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id");
        int id=sc.nextInt();


        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Product p=ses.get(Product.class,id);

        System.out.println(p.getProductId());
        System.out.println(p.getProductName());
        System.out.println(p.getProductPrice());
        System.out.println(p.getProductCatagory());


    }

}
