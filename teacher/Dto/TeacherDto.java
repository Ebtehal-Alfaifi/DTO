package com.example.teacher.Dto;

import com.example.teacher.Model.Address;
import com.example.teacher.Model.Course;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class TeacherDto {
    private String name;
    private int age;
    private String email;
    private double salary;
    private Address address;
    private List<CourseDto> courses;

    public TeacherDto(@NotEmpty(message = "name can not be empty") @Size(min = 2,max = 10,message = "name should be between 2 and 10") String name, @NotNull(message = "age can not be null") @Min(value = 23,message = "teacher age should be at least 23") Integer age, @NotEmpty(message = "email can not be empty") @Email(message = "email should be valid") @Size(max = 20,message = "your email can not be more than 20") String email, @NotNull(message = "salary can not be null") Integer salary, Address address, Set<Course> courseSet) {
    }
}
