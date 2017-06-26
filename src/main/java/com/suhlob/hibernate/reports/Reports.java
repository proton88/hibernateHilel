package com.suhlob.hibernate.reports;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Reports {
    public static List<ExamResult> getExamResults(String firstName, String lastName, Session session)
    {
        String query = "select new com.suhlob.hibernate.reports.ExamResult(e.student.lastName, e.subject.name, e.grade) " +
                "from Exam e where e.student.firstName= :firstName and e.student.lastName= :lastName";

        Query hibernateQuery=session.createQuery(query);
        hibernateQuery.setParameter("firstName",firstName);
        hibernateQuery.setParameter("lastName",lastName);

        return hibernateQuery.getResultList();
    }
}
