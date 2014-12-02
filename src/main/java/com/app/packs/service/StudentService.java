/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.packs.service;

import com.app.packs.model.Student;
import java.util.List;

/**
 *
 * @author Navneet
 */
public interface StudentService {
public void addStudent(Student st) ; 
public List<Student> listStudent();
public void updateStudent(Student st);
public Student getById(int id);
public void removeStudent(int id);    
}
