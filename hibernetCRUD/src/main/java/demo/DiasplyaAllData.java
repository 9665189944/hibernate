package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class DiasplyaAllData {
    static Configuration cfg;
    static SessionFactory factory;
    static Session ses;
    public static void main(String[] args) {


        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();


        List<Product> data=findAllStudentsWithCriteriaQuery();
        System.out.println("ID"+" ProductName"+" ProductPrice"+" ProductCategory");
        for(Product da:data)
        {
            System.out.println(da.getProductId()+"\t\t"+da.getProductName()+"\t\t"+da.getProductPrice()+"\t\t"+da.getProductCatagory());

        }

    }
    public static List<Product> findAllStudentsWithCriteriaQuery() {

        CriteriaBuilder cb = ses.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> rootEntry = cq.from(Product.class);
        CriteriaQuery<Product> all = cq.select(rootEntry);

        TypedQuery<Product> allQuery = ses.createQuery(all);
        return allQuery.getResultList();
    }
}
