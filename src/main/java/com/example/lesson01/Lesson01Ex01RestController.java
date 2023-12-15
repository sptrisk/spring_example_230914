package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody
public class Lesson01Ex01RestController {
	
	// URL : http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3 () {
		return "@RestController를 사용해서 String을 return해본다.";
	}
	
	
	// URL : http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4 () {
		Map<String, String> map = new HashMap<>();
		map.put("asdf", "fds");
		map.put("cvxcv", "dsa");
		map.put("adfds", "liky");
		map.put("dfa23", "bfag");
		return map;
	}
	
	// URL : http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // 일반 java bean(객체)
		data.setId(10);
		data.setName("김종휘");
		
		return data; // 일반 bean 객체도 json으로 변환된다.
	}
	
	// URL : http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("바다");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // OK-200, INTERNAL_SERVER_ERROR-500.....
		
	}
	
	
}
