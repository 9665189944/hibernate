package Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DisplayDetailsSpecificRecord {
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

        System.out.println("Enter the Designation");
        String desg=sc.next();

        Query query1=ses.createQuery("select e1.emp_name,e1.emp_email,p1.designation,p1.experience,a1.accountNo,a1.salary from Employee_master e1 left outer join AccountDetails a1 on e1.account=a1.accountId left outer join ProfessionalDetails p1 on p1.proId=e1.professional where designation='"+ desg+"'  ");
        List<String> EmployeeInfo=query1.list();
        Iterator itr=EmployeeInfo.iterator();
        while(itr.hasNext()) {
            Object[] arr=(Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]+"\t\t"+arr[2]+"\t\t"+arr[3]+"\t\t"+arr[4]+"\t\t"+arr[5]);
        }
    }
}
