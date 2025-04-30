package com.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeptController {

	@GetMapping("deptWrite")
	public String deptWrite() {
		return "dept/deptWrite";
	}
}
