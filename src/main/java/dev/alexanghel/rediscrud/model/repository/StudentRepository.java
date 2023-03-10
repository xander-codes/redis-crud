package dev.alexanghel.rediscrud.model.repository;

import dev.alexanghel.rediscrud.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> { }