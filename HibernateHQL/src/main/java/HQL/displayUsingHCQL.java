package HQL;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class displayUsingHCQL {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        //fetching complete
        Criteria crt1= ses.createCriteria(Product.class);
        //execute criteria
        List<Product> productList=crt1.list();
        //Process data
        for (Product p:productList) {
            System.out.println(p);
        }
        System.out.println("============================================================");

        //fetching data from specific column
        Criteria crt2=  ses.createCriteria(Product.class);
        crt2.setProjection(Projections.property("productName"));
        //execute criteria
        List<String> nameList=crt2.list();
        //Process data
        for (String p1:nameList) {
            System.out.println(p1);
        }
        System.out.println("=====================================================");


        //fetching data from specific column name and price
        Criteria crt3= ses.createCriteria(Product.class);
        ProjectionList coloum=Projections.projectionList();
        coloum.add(Projections.property("productName"));
        coloum.add(Projections.property("productPrice"));
        crt3.setProjection(coloum);
        //execute criteria
        List nameList1=crt3.list();
        //Process data
        Iterator itr=nameList1.iterator();
        while (itr.hasNext()){
            Object[] arr=(Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]);
        }
        System.out.println("=================================================================");
        //create criteria to display all Product having price greater than  20000.0
        Criteria crt4=ses.createCriteria(Product.class);
        crt4.add(Restrictions.ge("productPrice",2000.0));
        List<Product> productList2=crt4.list();
        for(Product p:productList2){
            System.out.println(p);
        }
        System.out.println("================================================================");
        //create criteria to display all Product from Electronic
        Criteria crt5=ses.createCriteria(Product.class);
        crt5.add(Restrictions.eq("productCategory" ,"GAGDATE"));
        List<Product> productList3=crt5.list();
        for(Product p:productList3){
            System.out.println(p);
        }
        System.out.println("=====================================================================");
        //create criteria to display all Product whose contains 'L'
        Criteria crt6=ses.createCriteria(Product.class);
        crt6.add(Restrictions.like("productName" ,"%L%"));
        List<Product> productList4=crt6.list();
        for(Product p:productList4){
            System.out.println(p);
        }
        System.out.println("========================================================");
        Criteria crt7=ses.createCriteria(Product.class);
        crt7.add(Restrictions.between("productPrice" ,30000.0,40000.0));
        List<Product> productList5=crt7.list();
        for(Product p:productList5){
            System.out.println(p);
        }
    }
}
