package com.example.teacher.Repository;

import com.example.teacher.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherByTeacherId(Integer id);


}
