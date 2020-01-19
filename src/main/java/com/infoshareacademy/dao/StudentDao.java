package com.infoshareacademy.dao;

import com.infoshareacademy.model.Student;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class StudentDao extends GenericDao<Student, Long> {

    public StudentDao() {
        super(Student.class);
    }

    public List<Student> findBornAfter(LocalDate date) {
        // Native Query vvvvv dlatego ich nie lubimy :C
//        Query query = entityManager.createNativeQuery(
//            "SELECT * FROM STUDENTS WHERE date_of_birth >= :param1 "
//                + "ORDER BY date_of_birth DESC");
//
//        query.setParameter("param1", date);
//
//        List<Student> students = new ArrayList<>();
//
//        List<Object[]> result = query.getResultList();
//        for (Object[] arr : result) {
//            BigInteger id = (BigInteger) arr[0];
//            String name = (String) arr[2];
//            String lastName = (String) arr[3];
//            Student s = new Student();
//            s.setId(id.longValue());
//            s.setName(name);
//            s.setSurname(lastName);
//            //....
//
//            students.add(s);
//        }
//
//
//        return students;

        // JPQL
//        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE "
//            + "s.dateOfBirth >= :param1 ORDER BY s.dateOfBirth DESC");
//
//        query.setParameter("param1", date);
//        return query.getResultList();

        // Named Query
        Query query = entityManager.createNamedQuery("Student.findBornAfter");
        query.setParameter("param1", date);
        return query.getResultList();
    }
}
