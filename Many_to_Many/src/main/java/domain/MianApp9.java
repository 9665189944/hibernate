package domain;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class MianApp9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        Criteria crt1= ses.createCriteria(Student.class);
        //execute criteria
        List<Student> List=crt1.list();
        System.out.println("============================================================");
        //Process data
        for (Student p:List) {
            System.out.println("Student NAME "+p.getStudentName());
            System.out.println("=========================================================");
            List<Course> courseList=p.getCourseList();
            for(Course o:courseList)
            {
                System.out.println("Course "+o.getCourseName());
            }
            System.out.println("=========================================================");
        }
        System.out.println("=============================================================");

    }
    }

