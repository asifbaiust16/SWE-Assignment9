package edu.mum.cs.cs425.eRegistrar.repositoies;

import edu.mum.cs.cs425.eRegistrar.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}