package com.example.teacher.Controller;

import com.example.teacher.Api.ApiResponse;
import com.example.teacher.Model.Course;
import com.example.teacher.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

@GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/{teacherId}/add")
    public ResponseEntity addNew(@PathVariable Integer teacherId, @RequestBody @Valid Course course){
        courseService.addNew(teacherId, course);
        return ResponseEntity.status(200).body(new ApiResponse(" course add success"));

    }


    @PutMapping("/{courseId}/update")
    public ResponseEntity update(@PathVariable Integer courseId,@RequestBody @Valid Course course){
    courseService.updateCourse(courseId, course);
    return ResponseEntity.status(200).body(new ApiResponse("update course success"));

    }

    @DeleteMapping("/{courseId}/delete")
    public ResponseEntity delete(@PathVariable Integer courseId){
    courseService.delete(courseId);
    return ResponseEntity.status(200).body(new ApiResponse("delete course success"));
    }



    @GetMapping("/get/{courseId}")
    public ResponseEntity getTeacherByCourseId(@PathVariable Integer courseId){
    return ResponseEntity.status(200).body(courseService.getTeacherNameByCourseId(courseId));

    }




}
