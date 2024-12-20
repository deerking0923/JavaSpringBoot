package com.springboot.biz.question;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.biz.answer.AnswerForm;
import com.springboot.biz.user.SiteUser;
import com.springboot.biz.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question") //보통 여따가 붙임
@Controller
@RequiredArgsConstructor //매개변수가 있는 생성자. 그래서 임플리먼츠 안하고 private final 변수를 사용가능함. 
public class QuestionController { //서비스 함수를 가져다가 화면에 보여주는 역할
	private final QuestionService questionService; //생성자를 만들면서 매개변수로 가져와서 이 클래스의 함수를 사용가능하게 됨.
	private final UserService userService;
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		SiteUser siteUser = this.userService.getUser(principal.getName());
		this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}

	
	/*
	 * @GetMapping("/list") //컨트롤러에는 이런 요청이 들어왔을때 어떤 작업을 할지가 들어간다. 겟매핑처럼.. public
	 * String list(Model model) { List<Question> questionList =
	 * this.questionService.getList(); model.addAttribute("questionList",
	 * questionList); return "question_list"; }
	 */
	
	@GetMapping("/list") //컨트롤러에는 이런 요청이 들어왔을때 어떤 작업을 할지가 들어간다. 겟매핑처럼..
	public String list(Model model, @RequestParam(value = "page", defaultValue ="0") int page) {
		Page<Question> paging= this.questionService.getList(page);
		model.addAttribute("paging", paging);
		return "question_list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {//AnswerForm
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
}
