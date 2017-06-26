package com.suhlob.hibernate;

import com.suhlob.hibernate.entity.Student;
import com.suhlob.hibernate.reports.ExamResult;
import com.suhlob.hibernate.reports.Reports;
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
        //session.save(new Student("John", "Smith", 33));

        //Student student=session.get(Student.class, 1l);
        //System.out.println(student.getExams());
        Query query = session.createQuery("from Student");
        List<Student> students=query.list();
        System.out.println(students);

        List<ExamResult> results=Reports.getExamResults("John", "Snow", session);
        System.out.println(results);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
