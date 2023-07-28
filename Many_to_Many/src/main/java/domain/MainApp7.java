package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class MainApp7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student id");
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

        Student s=ses.get(Student.class,id);

        if(s!=null) {
            System.out.println("Name:" + s.getStudentName());
            List<Course> courseList = s.getCourseList();
            for (Course c : courseList) {
                System.out.println(c.getCourseName());
            }
        }else{
            System.out.println("Student Not found");

        }
    }

}
