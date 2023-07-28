package Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddDetailsTable {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Employee_master.class);
        cfg=cfg.addAnnotatedClass(ProfessionalDetails.class);
        cfg=cfg.addAnnotatedClass(AccountDetails.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter the Employee Name");
        String employeeName=sc.next();
        System.out.println("Enter the Employee Email");
        String  email=sc.next();


        Employee_master e1=new Employee_master();
        e1.setEmp_name(employeeName);
        e1.setEmp_email(email);


        System.out.println("Enter the Employee designation");
        String employeeDesignation=sc.next();
        System.out.println("Enter the Employee Experience");
        int experience=sc.nextInt();


        ProfessionalDetails p1=new ProfessionalDetails();
        p1.setDesignation(employeeDesignation);
        p1.setExperience(experience);


        System.out.println("Enter the Employee Account NO");
        String accountNO=sc.next();
        System.out.println("Enter the Employee salary");
        double salary=sc.nextDouble();

        AccountDetails a1=new AccountDetails();
        a1.setAccountNo(accountNO);
         a1.setSalary(salary);

       e1.setProfessional(p1);
       e1.setAccount(a1);
        tx=ses.beginTransaction();
        ses.save(e1);
        tx.commit();
        System.out.println("insert record successfully");
    }
}
