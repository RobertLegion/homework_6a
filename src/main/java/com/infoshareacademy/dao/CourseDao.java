package com.infoshareacademy.dao;

import com.infoshareacademy.model.Course;
import com.infoshareacademy.model.CourseSummary;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CourseDao extends GenericDao<Course, String> {

    public CourseDao() {
        super(Course.class);
    }

    public Course findByName(String name) {
        return entityManager.find(Course.class, name);
    }

    public List<CourseSummary> getCoursesSummary() {
        return findAll().stream()
                .map(c -> {
                    String courseName = c.getName();
                    List<String> attendees = c.getStudents().stream()
                            .map(s -> s.getName() + " " + s.getSurname())
                            .collect(Collectors.toList());
                    List<String> teachers = c.getTeachers().stream()
                            .map(s -> s.getName() + " " + s.getSurname())
                            .collect(Collectors.toList());

                    return new CourseSummary(courseName, teachers, attendees);
                })
                .collect(Collectors.toList());
    }

}
