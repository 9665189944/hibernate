package One_T0_One;

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
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(StudentDetails.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Student s1=new Student();
        s1.setStudentName("Amit");
        s1.setStudentContact(24255);

        StudentDetails d1=new StudentDetails();
        d1.setMaddress("PUNE");
        d1.setMstream("ETC");
        d1.setMpercentage(50.0);

           s1.setDetails(d1);
           tx=ses.beginTransaction();
           ses.save(s1);
           tx.commit();
        System.out.println("insert record successfully");
    }
}
