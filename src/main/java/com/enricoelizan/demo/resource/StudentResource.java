package com.enricoelizan.demo.resource;

import com.enricoelizan.demo.model.Student;
import com.enricoelizan.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController // RESTFUL api
@RequestMapping("api/v1/students") // PATH
public class StudentResource {

    // Inject student service
    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            // define that this method will be served as a GET request
            method = RequestMethod.GET,
            // return type as JSON
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(
            // define that this method will be served as a GET request
            method = RequestMethod.GET,
            // return type as JSON
            produces = MediaType.APPLICATION_JSON_VALUE,
            // student id
            path = "{studentId}"
    )
    public Student getStudentById(@PathVariable("studentId") UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(
            // define that this method will be served as a GET request
            method = RequestMethod.DELETE,
            // return type as JSON
            produces = MediaType.APPLICATION_JSON_VALUE,
            // student id
            path = "delete/{studentId}"
    )
    public void deleteStudentById(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);
    }

    @RequestMapping(
            // define that this method will be served as a GET request
            method = RequestMethod.PUT,
            // return type as JSON
            produces = MediaType.APPLICATION_JSON_VALUE,
            // student id
            path = "update/{studentId}"
    )
    public void updateStudentById(@PathVariable("studentId") UUID studentId, @RequestBody Student student) {
        studentService.updateStudentById(studentId, student);
    }

    @RequestMapping(
            // define that this method will be served as a GET request
            method = RequestMethod.POST,
            // consumes JSON coming from the client
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    // @RequestBody takes the request body and then maps to the student object
    public void insertNewStudent(@RequestBody Student student) {
        studentService.persistNewStudent(UUID.randomUUID(), student);
    }

}
