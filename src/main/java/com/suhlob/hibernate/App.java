package com.suhlob.hibernate;

import com.suhlob.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        //session.save(new Student("John", "Snow", 21));

        //Student student=session.get(Student.class, 1l);
        //System.out.println(student.getExams());
        Query query = session.createQuery("from Student");
        List<Student> students=query.getResultList();
        System.out.println(students);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
