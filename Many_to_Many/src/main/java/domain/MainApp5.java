package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp5 {
    public static void main(String[] args) {

    Configuration cfg;
    SessionFactory factory;
    Session ses;
    Transaction tx;


    cfg=new Configuration();
    cfg=cfg.configure();
    cfg=cfg.addAnnotatedClass(Student.class);
    cfg=cfg.addAnnotatedClass(Course.class);
    factory=cfg.buildSessionFactory();
    ses=factory.openSession();

    Student s1=ses.get(Student.class,1);

    Course c1=ses.get(Course.class,3);

    s1.addCourse(c1);
        c1.addStudent(s1);
    tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(s1);
        tx.commit();
        System.out.println("insert Record");
   }
}
