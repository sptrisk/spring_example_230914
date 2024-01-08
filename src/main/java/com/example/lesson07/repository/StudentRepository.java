package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// @Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	
//	@PersistenceContext
//	private EntityManager em;
//	// JPA, Spring Data JPA
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	
	// 기본 제공 메소드
	// Spring Data JPA
	// SAVE(Entity ) -> 1. insert(id null), 2. update(id가 있음)
	// Entity findById(id)
	// void delete(엔티티객체)
	// List<엔티티객체> findAll();
	
	// ex02/2 - JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	// ex02/3
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	// ex02/4
	public List<StudentEntity> findByName(String name);
	
	// ex02/5
	public List<StudentEntity> findByNameIn(List<String> names);
	
	// ex02/6
	// public List<StudentEntity> findByNameAndDreamJob(String name, String dreamjob);
	
	public List<StudentEntity> findByEmailContaining(String email);
	
	public List<StudentEntity> findByNameStartingWith(String name);
	
	public List<StudentEntity> findByIdBetween(int id1, int id2);
	
}
