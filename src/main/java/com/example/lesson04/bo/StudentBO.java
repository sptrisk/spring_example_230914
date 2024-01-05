package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA로 INSERT 
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamjob) {
		
		StudentEntity student = StudentEntity.builder()
								.name(name)
								.phoneNumber(phoneNumber)
								.email(email)
								.dreamjob(dreamjob)
								.createdAt(ZonedDateTime.now())  // @UpdateTimeStamp가 있으면 생략 가능
								.build();
		
		return studentRepository.save(student);
		
	}

	
	
	// MyBatis로 INSERT
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
}
