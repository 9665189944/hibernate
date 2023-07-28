package Employee;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class query3 {

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

        System.out.println( "Enter the experience");
        int experience=sc.nextInt();

        Query query=ses.createQuery("select e.emp_name,a.salary from Employee_master e left outer join AccountDetails a on e.account=a.accountId left outer join ProfessionalDetails p on p.proId=e.professional where experience < '"+experience+"'  ");
         List<String> employeeinfo=query.list();
        Iterator itr=employeeinfo.iterator();
        while(itr.hasNext())
        {
            Object[] arr=(Object[]) itr.next();
            System.out.println("Employee Name"+"\t\t"+"salary");
            System.out.println(arr[0]+"\t\t\t"+arr[1]);
        }
    }
}
