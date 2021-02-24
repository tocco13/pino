package com.pinosoft.test.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

import com.pinosoft.test.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	FileUploadService fileuploadservice;
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	/*
	 * @RequestMapping("/upload") public String upload(ModelAndView
	 * mv, @RequestParam("profilepic") MultipartFile file) { String url =
	 * FileUploadService.restore(file); mv.addObject("url", url); return "result"; }
	 */
}	
