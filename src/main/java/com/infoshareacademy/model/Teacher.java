package com.infoshareacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "TEACHERS")
@NamedQuery(
                name = "Teacher.findAll",
                query = "SELECT s FROM Teacher s"
        )
public class Teacher implements ModelInterface<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pesel")
    private String pesel;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "last_name")
    @NotNull
    private String surname;

    @Override
    public String getId() {
        return pesel;
    }

    public void setId(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany
    @JoinTable(name = "TEACHERS_TO_COURSES",
            joinColumns = @JoinColumn(name = "teacher_pesel", referencedColumnName = "pesel"), // TEACHERS
            inverseJoinColumns = @JoinColumn(name = "course_name", referencedColumnName = "name"))

// COURSES
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String pesel, String name, String surname, List<Course> courses) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("pesel=").append(pesel);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", courses=").append(courses);
        sb.append('}');
        return sb.toString();
    }

}