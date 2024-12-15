package com.example.teacher.Service;

import com.example.teacher.Api.ApiException;
import com.example.teacher.Dto.CourseDto;
import com.example.teacher.Dto.StudentDto;
import com.example.teacher.Model.Course;
import com.example.teacher.Model.Student;
import com.example.teacher.Repository.CourseRepository;
import com.example.teacher.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
private final StudentRepository studentRepository;
private final CourseRepository courseRepository;



//getStudent
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDTOs = new ArrayList<>();//
        for (Student student : students) {
        List<CourseDto>courseDtos=new ArrayList<>();//
        for (Course c:student.getCourse()){
            CourseDto courseDto=new CourseDto(c.getName());
            courseDtos.add(courseDto);
        }
        StudentDto studentDto=new StudentDto(student.getName(),student.getAge(),student.getMajor(),courseDtos);
        studentDTOs.add(studentDto);
        }
        return studentDTOs;
    }




    ///add new student
//    public void addStudent(StudentDto studentDto) {
//        Student student1=new Student(studentDto.getName(),studentDto.getAge(),studentDto.getMajor(),studentDto.getCourses());
//        studentRepository.save(student1);
//    }



    public void addstudent(Student student){
        studentRepository.save(student);
    }


    //update Student


    public void updateStudent(Integer studentId,Student student){
        Student oldStudent=studentRepository.findStudentByStudentId(studentId);
        if (oldStudent==null){
            throw new ApiException("student not found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        oldStudent.setCourse(student.getCourse());
        studentRepository.save(oldStudent);

    }



    public void delete(Integer studentId){
        Student student=studentRepository.findStudentByStudentId(studentId);
        if (student==null){
            throw new ApiException("student not found");
        }


        studentRepository.delete(student);

    }






    // مو متأكدة منها
    public void changemejaor(Integer id, String major) {
        Student student = studentRepository.findStudentByStudentId(id);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        student.setMajor(major);
        student.setCourse(null);
        studentRepository.save(student);
    }




    public List<StudentDto> getListOfStudent(Integer course_id) {

        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException(" can not found");
        }
        List<Student> students = new ArrayList<>(course.getStudent());
        List<StudentDto> studentDTOS = new ArrayList<>();

        for (Student student : students) {
            List<CourseDto> courseDTOS = new ArrayList<>();
            for (Course course1 : student.getCourse()) {
                CourseDto courseDTO = new CourseDto(course1.getName());
                courseDTOS.add(courseDTO);
            }

            StudentDto studentDTO = new StudentDto(student.getName()
                    , student.getAge(),
                    student.getMajor(),
                    courseDTOS);
            studentDTOS.add(studentDTO);
        }

        return studentDTOS;
    }



}
