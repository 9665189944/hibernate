package One_T0_One;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplyaAllRecord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(StudentDetails.class);
        cfg=cfg.addAnnotatedClass(StudentDocument.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt1= ses.createCriteria(Student.class);
        //execute criteria
        List<Student> productList=crt1.list();
        //Process data
        for (Student p:productList) {
            System.out.println(p);
//            System.out.println(p.getDetails().getMaddress()+"   "+p.getDetails().getMstream());


        }
    }
}
