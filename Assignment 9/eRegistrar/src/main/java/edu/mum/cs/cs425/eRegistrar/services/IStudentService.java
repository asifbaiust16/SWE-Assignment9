package edu.mum.cs.cs425.eRegistrar.services;

import edu.mum.cs.cs425.eRegistrar.models.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface IStudentService {
    public void save( Student student);
    public List<Student> findAll();
    public Optional<Student> findById(Long id);
    public void update(Student student, Long id);
    public void delete(Long id);

}
