/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.packs.service;

import com.app.packs.dao.StudentDAO;
import com.app.packs.model.Student;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Navneet
 */
@Service
public class StudentServiceImpl implements StudentService{

    
   private StudentDAO studentDAO;

	
    
    @Override
    @Transactional
    public void addStudent(Student st) {
        this.studentDAO.addStudent(st);
    }

    @Override
     @Transactional
    public List<Student> listStudent() {
    
     return this.studentDAO.listStudent();
    }

    @Override
     @Transactional
    public void updateStudent(Student st) {
       this.studentDAO.updateStudent(st);
    }

    @Override
     @Transactional
    public Student getById(int id) {
        return studentDAO.getById(id);
    }

    @Override
     @Transactional
    public void removeStudent(int id) {
        this.studentDAO.removeStudent(id);
    }

    /**
     * @param studentDAO the studentDAO to set
     */
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

   
   
}
