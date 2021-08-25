package com.sf.springdemo.rest;

import com.sf.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    //@postconstruct to load the data only once

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Rupa", "Sri"));
        theStudents.add(new Student("Mary", "Smith"));
        theStudents.add(new Student("Mario", "Rossi"));
    }
    // for returning list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

//        List<Student> theStudents = new ArrayList<>();

//        theStudents.add(new Student("Rupa","Sri"));
//        theStudents.add(new Student("Mary","Smith"));
//        theStudents.add(new Student("Mario","Rossi"));


        return theStudents;
    }

    //return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler                 //generic exception any excep
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//
//        StudentErrorResponse error=new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
