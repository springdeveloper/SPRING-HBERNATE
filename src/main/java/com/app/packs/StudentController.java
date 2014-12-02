/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.packs;

import com.app.packs.model.Student;
import com.app.packs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
 private StudentService studentService;
 @Autowired(required=true)
	@Qualifier(value="studentService")
	public void setPersonService(StudentService st){
		this.studentService = st;
	}
        @RequestMapping(value = "/student" ,method =RequestMethod.GET)
       public String listStudent(Model model){
           model.addAttribute("student", new Student());
           model.addAttribute("studentlist",this.studentService.listStudent());
           
           return "student";
       }
        
        
   @RequestMapping(value= "/student/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("person") Student st){
		
		if(st.getId() == 0){
			//new person, add it
			this.studentService.addStudent(st);
		}else{
			//existing person, call update
			this.studentService.updateStudent(st);
		}
		
		return "redirect:/student";
		
	}
	     
     @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.studentService.removeStudent(id);
        return "redirect:/student";
    }   
        
   @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentService.getById(id));
         model.addAttribute("studentlist",this.studentService.listStudent());
        return "student";
    }     
        
        
}
