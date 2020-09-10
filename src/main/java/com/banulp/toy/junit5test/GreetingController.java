package com.banulp.toy.junit5test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping("/greeting")
	public String greeting() {
		String msg = "greeting";
		return msg;
	}

	@RequestMapping("/greetingfriend")
	public String greetingFriend(@RequestParam(name="order", required=false, defaultValue="1") Integer bestOrder) {
//		return String.valueOf(bestOrder);
		String msg = "greetingFreind" + greetingService.greetingToFriend(bestOrder);
		return msg;
	}

	@RequestMapping("/greetingfamily")
	public String greetingFamily(@RequestParam(name="order", required=false, defaultValue="1") Integer bestOrder) {
		String msg = "greetingFamily" + greetingService.greetingToFamily(bestOrder);
		return msg;
	}

}
