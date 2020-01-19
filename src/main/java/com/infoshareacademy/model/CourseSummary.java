package com.infoshareacademy.model;

import java.util.List;

public class CourseSummary implements ModelInterface<String> {

    private String courseName;

    private List<String> attendees;

    private List<String> teachers;

    public CourseSummary(String courseName, List<String> attendees, List<String> teachers) {
        this.courseName = courseName;
        this.attendees = attendees;
        this.teachers = teachers;
    }

    public String getId(){
        return courseName;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<String> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CourseSummary{");
        sb.append("courseName='").append(courseName).append('\'');
        sb.append(", teachers=").append(teachers);
        sb.append(", attendees=").append(attendees);
        sb.append('}');
        return sb.toString();
    }
}
