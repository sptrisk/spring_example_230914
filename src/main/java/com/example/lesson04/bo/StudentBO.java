package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	// JPA로 UPDATE
	public StudentEntity updateStudentDreamJobById(int id, String dreamjob) {
		// Select
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// Update - save
		if (student != null) {
			student.toBuilder() // 기존 필드값들은 유지하고 일부 필드값만 변경 - toBuilder
			.dreamjob(dreamjob)
			.build(); // 반드시 다시 저장
			
			// update
			student = studentRepository.save(student);
		}
		return student; // student or null

	}
	
	// JPA로 DELETE
	public void deleteStudentById(int id) {
		// select
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		// delete
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	
	
	// MyBatis로 INSERT
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	
	
	
}
