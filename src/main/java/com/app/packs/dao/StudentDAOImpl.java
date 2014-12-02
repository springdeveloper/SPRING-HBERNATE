/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.packs.dao;

import com.app.packs.model.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Navneet
 */
@Repository
public class StudentDAOImpl implements StudentDAO{

    
    
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
    
    
    
    @Override
    public void addStudent(Student st) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(st);
        logger.info("Add Student Successfully "+st);
        
    }
@SuppressWarnings("unchecked")
    @Override
    public List<Student> listStudent() {
      Session session=this.sessionFactory.getCurrentSession();
      List<Student> studentlis=session.createQuery("from Student").list();
      for(Student s:studentlis){
          logger.info("Student List"+s);
      }
      return studentlis;
    }

    @Override
    public void updateStudent(Student st) {
       Session session=this.sessionFactory.getCurrentSession();
       session.update(st);
       logger.info("Update Successfully"+st);
    }

    @Override
    public Student getById(int id) {
       Session session=this.sessionFactory.getCurrentSession();
       Student st=(Student)session.load(Student.class, new Integer (id));
       logger.info("Get by id"+st);
       return st;
       
    }

    @Override
    public void removeStudent(int id) {
      Session session=this.sessionFactory.getCurrentSession();
      Student st=(Student)session.load(Student.class,new Integer(id));
      if(null!=st){
       session.delete(st);
       logger.info("Delete Student SuccessFully"+st);
      }
    }
    
}
