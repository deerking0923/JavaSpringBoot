package com.springboot.biz.answer;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.biz.question.Question;
import com.springboot.biz.question.QuestionService;
import com.springboot.biz.user.SiteUser;
import com.springboot.biz.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final UserService userService;
	
	/*
	 * @PostMapping("/create/{id}") public String createAnswer(Model
	 * model, @PathVariable("id") Integer id, @RequestParam(value = "content")
	 * String content) { Question question = this.questionService.getQuestion(id);
	 * this.answerService.create(question, content); return
	 * String.format("redirect:/question/detail/%s", id); }
	 */
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm,
			BindingResult bindingResult, Principal principal) {
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		
		}
		this.answerService.create(question, answerForm.getContent(), siteUser);
		return String.format("redirect:/question/detail/%s", id);
	}
}
