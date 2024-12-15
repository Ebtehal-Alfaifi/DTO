package com.example.teacher.Model;

import com.example.teacher.Dto.CourseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;


    @NotEmpty(message = "student name can not be null")
    @Size(min = 2,max = 10,message = "name should be between 2 and 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;




    @NotNull(message = "age can not be null")
    @Column(columnDefinition = "int not null")
    private Integer age;


    @NotEmpty(message = "major can not be null")
    @Size(min = 2,max =20,message = " major should be between 2 and 10")
    private String major;



    @ManyToMany
    @JsonIgnore
    private Set<Course> course;


}
