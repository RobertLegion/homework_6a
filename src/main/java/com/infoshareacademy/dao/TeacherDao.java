package com.infoshareacademy.dao;

import com.infoshareacademy.model.Teacher;

import javax.ejb.Stateless;

@Stateless
public class TeacherDao extends GenericDao<Teacher, String> {

    public TeacherDao() {
        super(Teacher.class);
    }

}
