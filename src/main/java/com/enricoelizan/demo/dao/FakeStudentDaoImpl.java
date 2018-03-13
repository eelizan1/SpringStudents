package com.enricoelizan.demo.dao;

import com.enricoelizan.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao{
    // acting db
    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        this.database = new HashMap<>();
        // dummy data
        UUID studentId = UUID.randomUUID();
        database.put(studentId, new Student(studentId, 24, "Enrico", "Elizan", "Computer Science"));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        // .values returns a collection not a list so return an arraylist
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
