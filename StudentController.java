package com.student;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class StudentController {
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addRecord(@RequestParam(value="studName", required=false) String name
    		, @RequestParam(value="studAge", required=false) Integer age
    		, @RequestParam(value="studId", required=false) Integer id) {
		Student cntrl = new Student();
		cntrl.setName(name);
		cntrl.setAge(age);
		cntrl.setId(id);
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public List<Student> viewRecord() {
		Student cntrl = new Student();
		List<Student> result = cntrl.getListStudent();
        return result;
    }
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateRecord(@PathVariable Integer id, Model model) {
        return "Hello World!";
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteRecord(@PathVariable Integer id, Model model) {
        return "Hello World!";
    }

}
