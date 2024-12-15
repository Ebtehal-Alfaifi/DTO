package com.example.teacher.Dto;

import com.example.teacher.Model.Course;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDto {

    private String name;
    private int age;
    private String major;
    private List<CourseDto> courses;


}
