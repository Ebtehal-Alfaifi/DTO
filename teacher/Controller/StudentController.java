package com.example.teacher.Controller;

import com.example.teacher.Api.ApiResponse;
import com.example.teacher.Model.Student;
import com.example.teacher.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

private final StudentService studentService;



//@GetMapping("/get")
//public ResponseEntity getAll(){
//    return ResponseEntity.status(200).body(studentService.getAllStudents());
//}

@PostMapping("/add")
public ResponseEntity addNew(@RequestBody @Valid Student student){
    studentService.addstudent(student);
    return ResponseEntity.status(200).body(new ApiResponse("add success"));

}


@PutMapping("/put/{id}")
public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Student student){
    studentService.updateStudent(id,student);
    return ResponseEntity.status(200).body(new ApiResponse("update success"));
}}


//    @PutMapping("/{id}/change-major")
//    public ResponseEntity changeMajor(@PathVariable Integer id, @RequestParam String major) {
//
//    return ResponseEntity.status(200).body(studentService.changemejaor(id, major));)
//
//}
