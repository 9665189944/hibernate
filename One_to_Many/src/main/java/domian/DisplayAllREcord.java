package domian;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllREcord {
    public static void main(String[] args) {
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

        Criteria crt1= ses.createCriteria(Customer.class);
        //execute criteria
        List<Customer> List=crt1.list();
        //Process data
        for (Customer p:List) {
            System.out.println("NAME "+p.getCustomerName());
            List<Orders> ordersList=p.getOrderList();
            for(Orders o:ordersList)
            {
                System.out.println("ORDER NO "+o.getOrderNo());
                System.out.println("CART AMOUNT "+o.getOrderAmount());
                System.out.println("=========================================");
            }


        }
    }
}
