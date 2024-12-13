package com.springboot.biz.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.biz.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService { //INSERT, SELECT, UPDATE, DELETE 등의 역할
	private final QuestionRepository questionRepository;
	
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("질문이 존재하지 않습니다.");
		}
	}
}
