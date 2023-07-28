package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp1 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Movie.class);
        cfg = cfg.addAnnotatedClass(Viewer.class);
        cfg=cfg.addAnnotatedClass(Rating.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Movie m1=new Movie();
        m1.setMovieName("Adipurush");





//         Rating r1=new Rating();
//        Movie m2=ses.get(Movie.class,2);
//         r1.setMovieRef(m2);
//         Viewer v2=ses.get(Viewer.class,1);
//         r1.setViewerRef(v2);
//         r1.setRatings(8.5);






        tx=ses.beginTransaction();
//        ses.save();


        tx.commit();
        System.out.println("insert record successfully");






    }
}
