package com.example.teacher.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    private Integer teacherId;


    @NotEmpty(message = "name can not be empty")
    @Size(min = 2,max = 10,message = "name should be between 2 and 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;



    @NotNull(message = "age can not be null")
    @Min(value = 23,message = "teacher age should be at least 23")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "email can not be empty")
    @Email(message = "email should be valid")
    @Size(max = 20,message = "your email can not be more than 20")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String email;


    @NotNull(message = "salary can not be null")
    @Column(columnDefinition = "int not null")
    private Integer salary;


@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;


@OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courseSet;



}
