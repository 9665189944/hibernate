package One_T0_One;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp2 {
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

        System.out.println("Enter the Student Name");
        String studentName=sc.next();
        System.out.println("Enter the Student Contact");
        int studentContact=sc.nextInt();


        Student s1=new Student();
        s1.setStudentName(studentName);
        s1.setStudentContact(studentContact);


        System.out.println("Enter the Student Address");
        String studentAddress=sc.next();
        System.out.println("Enter the Student Stream");
        String studentStream=sc.next();
        System.out.println("Enter the Student Percentage");
        double studentPercentage=sc.nextDouble();

        StudentDetails d1=new StudentDetails();
        d1.setMaddress(studentAddress);
        d1.setMstream(studentStream);
        d1.setMpercentage(studentPercentage);

        System.out.println("Enter the Student Pan NO");
        String studentPan_no=sc.next();
        System.out.println("Enter the Student Passport");
        String studentPassport=sc.next();

        StudentDocument d2=new StudentDocument();
        d2.setDpan(studentPan_no);
        d2.setDpassport(studentPassport);


        s1.setDocument(d2);
        s1.setDetails(d1);
        tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("insert record successfully");
    }
    }

