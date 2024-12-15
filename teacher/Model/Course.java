package com.example.teacher.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty(message = "course name can not be null")
    @Size(min = 3,max = 10,message = "course name should be between 3 and 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;




    @ManyToOne
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany(mappedBy = "course")
    private Set<Student>student;
}
