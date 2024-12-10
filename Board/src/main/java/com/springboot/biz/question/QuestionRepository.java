package com.springboot.biz.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	//SELECT * FROM QUESTION WHERE subject = ?
	Question findBySubject(String subject);
	
	
	//OR > findBySubjectOrContent
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
}
