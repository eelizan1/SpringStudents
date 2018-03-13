package com.enricoelizan.demo.dao;

import com.enricoelizan.demo.model.Student;

import java.util.List;
import java.util.UUID;

/*
* USING AN INTERFACE ALLOWS US TO HAVE MULTIPLE IMPLEMENTATIONS FOR THIS DATA ACCESS OBJECT
* */
public interface StudentDao {
    // OPERATIONS FOR DATABASE
    int insertNewStudent(UUID studentId, Student student);
    Student selectStudentById(UUID studentId);
    List<Student> selectAllStudents();
    int updateStudentById(UUID studentId, Student studentUpdate);
    int deleteStudentById(UUID studentId);
}
