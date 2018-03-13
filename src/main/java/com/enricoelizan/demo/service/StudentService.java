package com.enricoelizan.demo.service;

import com.enricoelizan.demo.dao.StudentDao;
import com.enricoelizan.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/* SERVICE LAYER IS RESPONSIBLE FOR HANDLING THE BUSINESS LOGIC ABOUT THE APPLICATION IN WHICH YOU DECIDE WHAT TO DO WITH THE DATA*/
@Service // allows to be autowired where ever we need it
public class StudentService {
    // REFERENCE TO THE DAO - DEPENDENCY INJECTION
    private final StudentDao studentDao;
    @Autowired // allows this class to use the FakeStudentDao
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentId);
        return studentDao.insertNewStudent(studentUid, student);
    }
    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }
    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        return studentDao.updateStudentById(studentId, studentUpdate);
    }
    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }
}
