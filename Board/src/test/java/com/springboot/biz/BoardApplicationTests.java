package com.springboot.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.biz.answer.Answer;
import com.springboot.biz.answer.AnswerRepository;
import com.springboot.biz.question.Question;
import com.springboot.biz.question.QuestionRepository;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;
    
    @Test
    //@Transactional
    void contextLoads() {
    	/*
        Question q1 = new Question();
        q1.setSubject("스카이");
        q1.setContent("언제 해");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("제주 크런치");
        q2.setContent("도장 가서 나눠드려야겠다 ㅎㅎ");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    	
    	//this.questionRepository.deleteAll();
    	
    	/*
    	Question q = this.questionRepository.findBySubjectAndContent("게시판이 무엇인가요?", "게시판을 만드는 방법을 알고 싶습니다");
    	System.out.println(q.getId());
    	System.out.println(q.getCreateDate());
    
    	*/
    	/*
    	List<Question> all = this.questionRepository.findAll();
    	assertEquals(2,all.size());
    	
    	Question q = all.get(0);
    	//assertEquals("그래서 오늘은...", q.getSubject());
    	
    	//Optional<Question> oq = this.questionRepository.findById(1);
    	*/
    	/*
    	Question q = this.questionRepository.findBySubject("박용우의 스위치온 다이어트");
    	System.out.println(q.getSubject());
    	System.out.println(q.getContent());
    	assertEquals(3, q.getId());
    	
    	Question q2 = this.questionRepository.findBySubjectAndContent("그래서 오늘은...", "단식하려고요 ㅠ.ㅠ");
    	System.out.println(q2.getId());
    	System.out.println(q2.getCreateDate());*/
    	
    	/*List<Question> qList = this.questionRepository.findBySubjectLike("게시판%");
    	Question q = qList.get(0);
    	System.out.println(q.getSubject());
    	System.out.println(q.getId());
    	
    	assertEquals("게시판입니다", q.getSubject());*/
    	/*
    	Optional<Question> oq = this.questionRepository.findById(5);
    	assertTrue(oq.isPresent());
    	Question q = oq.get();
    	q.setSubject("배고파요");
    	this.questionRepository.save(q);*/
    	/*
    	
    	System.out.println("삭제 전 게시판 개수 : " + this.questionRepository.count());
    	Optional<Question> oq = this.questionRepository.findById(4);
    	Question q = oq.get();
    	this.questionRepository.delete(q);
    	System.out.println("삭제 후 게시판 개수 : " + this.questionRepository.count());
    	*/
    	/*
    	Optional<Question> oq = this.questionRepository.findById(6);
    	Question q = oq.get();
    	
    	Answer a = new Answer();
    	a.setContent("그치만 오늘은 아침에 참치상추비빔밥을 먹었고요, 점심은 쉐이크랑 두부유부초밥 먹을거예요");
    	a.setQuestion(q);
    	a.setCreateDate(LocalDateTime.now());
    	this.answerRepository.save(a);
    	/*
    	Optional<Question> oq = this.questionRepository.findById(3);
    	Question q = oq.get();
    	List<Answer> answerList = q.getAnswerList();
    	System.out.println(answerList.get(0).getContent());
    	System.out.println(answerList.get(1).getContent());
    	//System.out.println(answerList.get(0).getId());
    	//System.out.println(answerList.get(0).getCreateDate());
    	*/
    	
    }
}
