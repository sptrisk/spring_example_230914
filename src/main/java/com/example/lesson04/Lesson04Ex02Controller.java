package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	@Autowired
	private StudentBO studentBO;
	// 학생 추가 화면
	// http://localhost:8080/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	
	// 방금 가입된 학생 화면 & DB INSERT
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student  // 태그의 name 속성 parameter와 이름이 같은 필드에 mapping
			) {
		
		// DB INSERT
		studentBO.addStudent(student);
		
		// DB에서 방금 가입된 사용자 SELECT
		int id = student.getId();
		// select student  by id 
		
		// MODEL 객체에 담기
		
		// 화면 뿌리기
		return "lesson04/afterAddStudent";
		
	}
	
	
	
	
}
