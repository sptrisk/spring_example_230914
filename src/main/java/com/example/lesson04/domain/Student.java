package com.example.lesson04.domain;

import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {
	private int id;
	private String name;
	
	private String phoneNumber;
	private String email;
	private String dreamjob;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
}
