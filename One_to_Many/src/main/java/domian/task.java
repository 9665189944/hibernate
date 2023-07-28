package domian;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class task {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Customer.class);
        cfg = cfg.addAnnotatedClass(Orders.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Query query1 = ses.createQuery("select c.customerName,o.orderNo,count(o.customerRef) from Customer c  inner join Orders o on c.customerId=o.customerRef group by  o.customerRef having count(o.customerRef)>2");

        List<String> Li = query1.list();
        Iterator itr = Li.iterator();
        while (itr.hasNext()) {
            Object[] arr = (Object[]) itr.next();
            System.out.println(arr[0] + "\t\t" + arr[1]);
        }
    }
}
