package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C: Create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "테스트";
		String phoneNumber = "01012345678";
		String email = "test@test.com";
		String dreamjob = "테스트";
		
		// 방금 인서트된 pk id도 바로 얻어낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamjob);
	}
	
	// U : Update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 5번인 dreamjob을 변경
		// 5, 디자이너
		return studentBO.updateStudentDreamJobById(5, "디자이너");
		
	}
	
	// D : Delete
	@GetMapping("/3")
	public String delete() {
		// id = 5
		studentBO.deleteStudentById(5);
		
		return "삭제 완료";
	}
	
	
	
}
