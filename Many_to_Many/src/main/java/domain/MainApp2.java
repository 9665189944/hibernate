package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp2 {
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

        Student s1=new Student();
        s1.setStudentName("Ajit");

        Student s2=new Student();
        s2.setStudentName("Anuj");

        Course c1=new Course();
        c1.setCourseName("sql");



        c1.addStudent(s1);
        c1.addStudent(s2);

        tx= ses.beginTransaction();
        ses.save(s1);
        ses.save(s2);
        ses.save(c1);

        tx.commit();
        System.out.println("insert record successfully");





    }
}
