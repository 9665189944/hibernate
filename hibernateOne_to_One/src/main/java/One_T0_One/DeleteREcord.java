package One_T0_One;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteREcord {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id");
        int id=sc.nextInt();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(StudentDetails.class);
        cfg = cfg.addAnnotatedClass(StudentDocument.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();



        Student s=ses.get(Student.class,id);


        if(s!=null)
        {
            tx=ses.beginTransaction();
            ses.delete(s);
            tx.commit();
            System.out.println("Student deleted");
        }else {
            System.out.println("Invalid Student Id");
        }

    }
}
