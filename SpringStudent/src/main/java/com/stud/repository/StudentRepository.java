package com.stud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stud.student.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
