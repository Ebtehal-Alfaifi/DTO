package com.example.teacher.Service;

import com.example.teacher.Api.ApiException;
import com.example.teacher.Dto.TeacherDto;
import com.example.teacher.Model.Address;
import com.example.teacher.Model.Teacher;
import com.example.teacher.Repository.AddressRepository;
import com.example.teacher.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDto> teacherDTOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            TeacherDto teacherDTO = new TeacherDto(
                    teacher.getName(),
                    teacher.getAge(),
                    teacher.getEmail(),
                    teacher.getSalary(),
                    teacher.getAddress(),
                    teacher.getCourseSet());
            teacherDTOs.add(teacherDTO);
        }
        return teacherDTOs;
    }


    public void addNew(Teacher teacher){
        teacherRepository.save(teacher);
    }


    public void update(Integer id,Teacher teacher){
        Teacher old=teacherRepository.findTeacherByTeacherId(id);
        if (old==null){
            throw new ApiException("teacher not found");
        }

        old.setAge(teacher.getAge());
        old.setName(teacher.getName());
        old.setEmail(teacher.getEmail());
        old.setSalary(teacher.getSalary());
        teacherRepository.save(old);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherByTeacherId(id);
        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        Address address=addressRepository.findAddressByAddressId(id);
        teacher.setAddress(null);
        addressRepository.delete(address);
        teacherRepository.delete(teacher);

    }


    //get all teacher details by id

    public TeacherDto getTeacherDetailsById(Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherByTeacherId(teacherId);
        if (teacher == null) {
            throw new RuntimeException("Teacher not found");
        }
        Address address = addressRepository.findAddressByAddressId(teacherId);
        teacher.setAddress(address);
        return new TeacherDto(
                teacher.getName(),
                teacher.getAge(),
                teacher.getEmail(),
                teacher.getSalary(),
                teacher.getAddress(),
                teacher.getCourseSet()
        );
    }





}
