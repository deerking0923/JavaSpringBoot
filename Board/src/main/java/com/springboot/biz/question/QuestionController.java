package com.springboot.biz.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question") //보통 여따가 붙임
@Controller
@RequiredArgsConstructor //매개변수가 있는 생성자. 그래서 임플리먼츠 안하고 private final 변수를 사용가능함. 
public class QuestionController { //서비스 함수를 가져다가 화면에 보여주는 역할
	private final QuestionService questionService; //생성자를 만들면서 매개변수로 가져와서 이 클래스의 함수를 사용가능하게 됨.
	
	@GetMapping("/list") //컨트롤러에는 이런 요청이 들어왔을때 어떤 작업을 할지가 들어간다. 겟매핑처럼..
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
}
