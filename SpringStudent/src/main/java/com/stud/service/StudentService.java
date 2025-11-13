package com.stud.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stud.repository.StudentRepository;
import com.stud.student.Student;
/**Service class: All the business logic of the app is here.Create service to add values to the database.These classes are auto-detected by the spring context when the annotation-based configuration is used along with class path scanningAutowired : SB creates an instance of StudentRepository and injects into StudentService
*/

@Service
public class StudentService {
@Autowired
StudentRepository studentRepository;
/**logic for saving an entity to the database: Here we are creating a save method in our service which will
* be calling the save method of the repository so all these methods are predefined in the repository so
* when you have your jpa repository it gives you awhole bunch of method for saving for updating for 
* fetching and for deleting so you don't have to write anything yourself so this is the beauty of
spring boot so i write this save method this is going to save an entity to my database 
*/
public Student save(Student std)
{
return studentRepository.save(std);
}
public Student getStudent(int id)
{
return studentRepository.findById(id).get();
}
public Student update(int id, Student student)
{
Student stds=studentRepository.findById(id).get();
stds.setName(student.getName());
stds.setAge(student.getAge());
return studentRepository.save(stds);
}
public String delete(int id)
{
studentRepository.deleteById(id);
return "Entity deleted has the Id="+id;
}
public List<Student>getStdlist()
{
return studentRepository.findAll();
}
}
