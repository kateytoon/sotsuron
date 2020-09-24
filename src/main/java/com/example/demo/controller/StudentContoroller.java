package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.ApicommentRepository;
import com.example.demo.repository.AppliRepository;
import com.example.demo.repository.ComlistRepository;
import com.example.demo.repository.RepcommentRepository;
import com.example.demo.repository.ReportRepository;


@Controller
public class StudentContoroller {
	@Autowired
	AppliRepository appRepository;
	@Autowired
	ReportRepository repRepository;
	@Autowired
	ComlistRepository comRepository;
	@Autowired
	ApicommentRepository apicommentRepository;

	@Autowired
	RepcommentRepository repcommentRepository;

	@RequestMapping(value = "/students/application/list", method = RequestMethod.GET)
	public String AllApp(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("Datas", appRepository.findByMyName(auth.getName()));
		return "students/application/list";
	}












}