package com.sf.onetone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
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
            Student s= new Student(1,"OnetoOne",89);

            s.setLaptop(laptop);

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
