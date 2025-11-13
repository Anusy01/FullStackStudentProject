package com.stud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stud.service.StudentService;
import com.stud.student.Student;
import com.stud.service.StudentService;
import com.stud.student.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

 
@RestController
@RequestMapping("/students")
public class StudentController {
@Autowired
private StudentService studentService;
//http://localhost:8086/students --POST
@PostMapping
public Student addStudent(@RequestBody Student student )
{
return studentService.save(student);
}
//http://localhost:8086/students/2 --GET
@GetMapping(path="/{id}")
public Student getStudent(@PathVariable int id)
{
return studentService.getStudent(id); 
}
//http:localhost:8086/students/2 --PUT
@PutMapping(path="/{id}")
public Student updateStudent(@PathVariable int id, @RequestBody Student student)
{
return studentService.update(id,student);
}
//http:localhost:8086/students/3 --DELETE
@DeleteMapping(path="/{id}")
public String deleteStudent(@PathVariable int id)
{
return studentService.delete(id); 
}
//http:localhost:8086/students --GET
@GetMapping
public List<Student>getAllStudents()
{
return studentService.getStdlist();
}
}
