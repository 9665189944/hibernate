package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class MainApp8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Course id");
        int id= sc.nextInt();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;


        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(Course.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

 Course s =ses.get(Course.class,id);

        if(s!=null) {

            List<Student> studentList = s.getStudentList();
            for (Student c : studentList) {
                System.out.println("Student Name:"+c.getStudentName());
            }
        }else{
            System.out.println("Student Not found");

        }

    }
}
