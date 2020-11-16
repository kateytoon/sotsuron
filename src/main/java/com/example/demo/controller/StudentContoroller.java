package com.example.demo.controller;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Application;
import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyList;
import com.example.demo.entity.Report;
import com.example.demo.entity.Student;
import com.example.demo.repository.ApicommentRepository;
import com.example.demo.repository.AppliRepository;
import com.example.demo.repository.ComRepository;
import com.example.demo.repository.ComlistRepository;
import com.example.demo.repository.RepcommentRepository;
import com.example.demo.repository.ReportRepository;
import com.example.demo.repository.StudentRepository;


@Controller
public class StudentContoroller {
	@Autowired
	AppliRepository appRepository;
	@Autowired
	ReportRepository repRepository;
	@Autowired
	ComlistRepository comRepository;
	@Autowired
	ComRepository companyRepository;
	@Autowired
	ApicommentRepository apicommentRepository;

	@Autowired
	RepcommentRepository repcommentRepository;
	@Autowired
	StudentRepository studentRepository;

	@RequestMapping(value = "/students/application/list", method = RequestMethod.GET)
	public String AllApp(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("Datas", studentRepository.findByMyName(auth.getName()));
		return "students/application/list";
	}

	@RequestMapping(value = "/students/application/create", method = RequestMethod.GET)
	public String AddApp(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("Datas", studentRepository.serchSName(auth.getName()));
		model.addAttribute("api", new Application());
		return "students/application/addForm";
	}

	@RequestMapping(value = "/students/application/commit", method = RequestMethod.POST)
	public String CommitApp(Model model ,Application api,@RequestParam("company") List<String> com) {
		System.out.println(com);
		Company company = new Company();
		List<Company> list = new ArrayList<Company>();
		for(int i=0;i < com.size();i+=2) {
			if(!(com.get(i).equals("")) && !(com.get(i+1).equals(""))) {
				company = new Company(com.get(i),com.get(i+1));

				company.setC_ID(companyRepository.selectNextVal());
				companyRepository.save(company);
				list.add(company);
			}
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student s = studentRepository.serchSName(auth.getName());
		api.setStudent(s);
		api.setUNAPPROVED(1);
		int seq = studentRepository.selectNextVal();

		//System.out.println(seq);
		seq++;
		api.setAPI_ID(seq);
		appRepository.save(api);
		appRepository.flush();
		companyRepository.flush();
		for(int i=0;i<list.size();i++) {
			comRepository.save(new CompanyList(api,list.get(i)));
		}




		return "students/application/endCommit";
	}
	@RequestMapping(value = "/students/report/list", method = RequestMethod.GET)
	public String AllRep(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("Datas", studentRepository.serchRepFlg(auth.getName()));
		//System.out.print(studentRepository.serchRepFlg(auth.getName()).get(0).getREP_FLG());
		model.addAttribute("Reps", studentRepository.findByMyRep(auth.getName()));
		//System.out.print(studentRepository.findByMyRep(auth.getName()).get(0).getREP_FLG());
		return "students/report/list";
	}
	@RequestMapping(value = "/students/report/create/{id}", method = RequestMethod.GET)
	public String AddRep(Model model,@PathVariable String id) {
		model.addAttribute("Datas", appRepository.findByAPI_ID(Integer.parseInt(id)));
		model.addAttribute("comlist",comRepository.findByAPI_ID(Integer.parseInt(id)));
		model.addAttribute("rep", new Report());
		return "students/report/addForm";
	}

	@RequestMapping(value = "/students/report/commit", method = RequestMethod.POST)
	public String CommitRep(Model model,Report rep,@RequestParam("api_id") int num) {
		System.out.println(num);
		rep.setApplication(appRepository.findByAPI_ID(num));
		repRepository.save(rep);
		return "students/report/endCommit";
	}
	
	













}