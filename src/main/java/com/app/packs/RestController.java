/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.packs;

import com.app.packs.model.Student;
import com.app.packs.service.StudentService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Navneet
 */
@Controller
public class RestController {
   
 @Autowired
 private StudentService studentService;
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	
	@RequestMapping(value = RestUrl.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getStudent() {
		logger.info("Start getStudentData");
		Map<String, Object> map = new HashMap<String, Object>();
	 List<Student> list=studentService.listStudent();
           map.put("messages", list);
		return map;
	}
        
     	    
        
      @RequestMapping(value="/rest/student/create/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addPerson(@RequestBody Student person) {
        
        studentService.addStudent(person);
        return new ResponseMessage(ResponseMessage.Type.success, "personAdded");
    }   
         @RequestMapping(value = "/rest/student/{id}", method = RequestMethod.GET)
         
	public @ResponseBody Map<String, Object> getStudent(@PathVariable("id") int id) {
            System.out.println(id);
            Map<String, Object> map = new HashMap<String, Object>();
		Student person = new Student();
		try {
			person = studentService.getById(id);
                        System.out.println(person.getName());
                     map.put("kk", person);
                   	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
         @RequestMapping(value = "/rest/student/{id}", method = RequestMethod.DELETE)
         @ResponseBody
         public ResponseMessage deleteStudent(@PathVariable int id) {
        	 studentService.removeStudent(id);
             return new ResponseMessage(ResponseMessage.Type.success, "StudentDeleted");
         }       
         
         
      
}
