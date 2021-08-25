package com.sf.manytomany;

import com.sf.manytomany.Laptop;
import com.sf.manytomany.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();


        try {
            System.out.println("Creating new student and laptop object...");

            Laptop laptop = new Laptop(101,"Hp");
            Student s= new Student(1,"Abi",89);

            s.getLaptop().add(laptop);

            laptop.getStudent().add(s);

            session.beginTransaction();

            session.save(laptop);
            session.save(s);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
