package One_T0_One;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp3 {
    public static void main(String[] args) {

        ///Display Specific Record
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

        System.out.println("Enter the id");
        int id=sc.nextInt();
        Student s1=ses.get(Student.class,id);
        System.out.println("Name "+s1.getStudentName());
        System.out.println("Contact "+s1.getStudentContact());
        StudentDetails detail=s1.getDetails();
        System.out.println("ADDRESS "+detail.getMaddress());
        System.out.println("STREAM "+detail.getMstream());
        System.out.println("PERCENTAGE "+detail.getMpercentage());
        StudentDocument document=s1.getDocument();
        System.out.println("pan  "+document.getDpan());
        System.out.println("passport "+document.getDpassport());


    }
}
