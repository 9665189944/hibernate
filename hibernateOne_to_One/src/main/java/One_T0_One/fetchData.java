package One_T0_One;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class fetchData {
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

        System.out.println("Enter the Stream");
        String strem=sc.next();

        Query query1=ses.createQuery("select s.studentName,d.maddress,d.mstream,d.mpercentage from Student s left outer join StudentDetails d on s.details=d.detailsId where d.mstream ='"+strem+"'");
        List<String> ProductLi=query1.list();
        Iterator itr=ProductLi.iterator();
        while(itr.hasNext()) {
            Object[] arr=(Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]+"\t\t"+arr[2]+"\t\t"+arr[3]);
        }

    }
}
