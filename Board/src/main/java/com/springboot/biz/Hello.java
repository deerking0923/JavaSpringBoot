package com.springboot.biz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
	@RequestMapping("he")
	@ResponseBody
	public String hello() {
		return "안녕하세요 배고프네요 오늘 밥은 육회비빔밥입니다";
	}
}
