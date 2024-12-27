package com.springboot.biz.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	
	Page<Question> findAll(Pageable Pagaable);
	//SELECT * FROM QUESTION WHERE subject = ?
	Question findBySubject(String subject);
	
	//Question findById(int id);
	
	//OR > findBySubjectOrContent
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	
	@Query("SELECT DISTINCT q FROM Question q "
			+ "LEFT OUTER JOIN SiteUser u1 ON q.author = u1 "
			+ "LEFT OUTER JOIN Answer a ON a.question = q "
			+ "LEFT OUTER JOIN SiteUser u2 ON a.author = u2 "
			+ "WHERE q.content like %:kw% "
			+ "or q.subject like %:kw% "
			+ "or u1.username like %:kw% "
			+ "or a.content like %:kw% "
			+ "or u2.username like %:kw% ")
	Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
	
}
