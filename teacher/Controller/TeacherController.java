package com.example.teacher.Controller;

import com.example.teacher.Api.ApiResponse;
import com.example.teacher.Dto.TeacherDto;
import com.example.teacher.Model.Teacher;
import com.example.teacher.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addNew(@RequestBody @Valid Teacher teacher){
        teacherService.addNew(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("add success"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("update success"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete success"));
    }



    //get teacher details
@GetMapping("/details/{id}")
public ResponseEntity<TeacherDto> getTeacherDetails(@PathVariable Integer teacherId) {

    return ResponseEntity.status(200).body(teacherService.getTeacherDetailsById(teacherId));
}



}
