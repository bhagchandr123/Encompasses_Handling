package com.example.Encompasses_Handling.service;

import com.example.Encompasses_Handling.model.Student;
import com.example.Encompasses_Handling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            // Update student fields here
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            // ...
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
