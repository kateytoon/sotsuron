package com.example.demo.controller;




import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Apicomment;
import com.example.demo.entity.Application;
import com.example.demo.entity.Repcomment;
import com.example.demo.entity.Report;
import com.example.demo.entity.Student;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ApicommentRepository;
import com.example.demo.repository.AppliRepository;
import com.example.demo.repository.ComlistRepository;
import com.example.demo.repository.RepcommentRepository;
import com.example.demo.repository.ReportRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.UserAccountService;


@Controller
public class DataController {
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

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	UserAccountService sv = new UserAccountService();


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPost() {
		return "redirect:/login-error";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

		return "signup/register";
	}
	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public String registerStudent(@RequestParam("username") String name,@RequestParam("password") String pass,Model model) {
		try {
			sv.registerUser(name, pass);

			model.addAttribute("username", name);
			model.addAttribute("student", new Student());
			return "signup/registerStudent";
		}catch(Exception e) {
			model.addAttribute("error", "このユーザー名はすでに使用されています。");
			register(model);
			return "signup/register";
		}
	}
	@PostMapping("/commitRegister")
	public String commitRegister(@ModelAttribute("student") Student student,Model model) {
		System.out.println(student.getAccount().getPassword());
		student.setAccount(accountRepository.findByUsername(student.getAccount().getUsername()));
		studentRepository.save(student);
		return "login";

	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
			LocalDateTime date1 = LocalDateTime.now();
			model.addAttribute("Datas", appRepository.findByTodayApplication(date1));
			return "teacheres/index";
		}else {
			model.addAttribute("Datas", studentRepository.findByMyName(auth.getName()));
			return "students/index";
		}
	}
	@RequestMapping(value = "/application/list", method = RequestMethod.GET)
	public String deniedApp(Model model) {
		model.addAttribute("Datas", appRepository.findByUnapprovedApplication());
		//System.out.println(appRepository.findByUnapprovedApplication().get(0).getAPI_DATE().getClass());
		return "teacheres/application/list";
	}

	@RequestMapping(value = "/report/list", method = RequestMethod.GET)
	public String deniedReport(Model model1) {
		model1.addAttribute("Datas", repRepository.findByUnsubmitReport());
		return "teacheres/report/list";
	}



	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String seachdate(@RequestParam("since") Date date, Model model) {
		System.out.println(date);
		LocalDate localDate = date.toLocalDate();
		System.out.println(localDate);
		model.addAttribute("Datas", appRepository.findDateApplication((localDate.atStartOfDay())));
		return"teacheres/index";
	}

	@GetMapping("/app/detail/{id}")
	public String detailAppData(@PathVariable String id,Model model) {
		model.addAttribute("data",appRepository.findByAPI_ID(Integer.parseInt(id)));
		model.addAttribute("comlist",comRepository.findByAPI_ID(Integer.parseInt(id)));
		return "teacheres/application/detail";
	}

	@GetMapping("/rep/detail/{id}")
	public String detailRepData(@PathVariable String id,Model model) {
		model.addAttribute("data",repRepository.findByReIdAndUnSubmit(Integer.parseInt(id)));
		int apiId = repRepository.findByApiId(Integer.parseInt(id)).getRE_ID();
		model.addAttribute("comlist",comRepository.findByAPI_ID(apiId));
		return "teacheres/report/detail";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model) {
		return "search/search";
	}
	@RequestMapping(value = "/application/commit", method = RequestMethod.POST)
	public String apicommit(Model model,@RequestParam("hyouka") String hyouka,@RequestParam("approved") String approved,@RequestParam("id") String id) {
		//System.out.println(hyouka+" "+approved+" "+id);

		Application api = appRepository.findByAPI_ID(Integer.parseInt(id));
		Apicomment data = new Apicomment(api,hyouka);
		apicommentRepository.save(data);

		if(approved.equals("0")) {
			//System.out.println("a");
			api.setUNAPPROVED(0);
			api.setAPPROVED(1);
		}else if(approved.equals("1")) {

		}else if(approved.equals("2")) {

			api.setUNAPPROVED(0);
			api.setDENIED(1);
		}
		appRepository.save(api);
		deniedApp(model);
		return "teacheres/application/list";
	}
	@RequestMapping(value = "/rep/commit", method = RequestMethod.POST)
	public String repcommit(Model model,@RequestParam("hyouka") String hyouka,@RequestParam("approved") String approved,@RequestParam("id") String id) {
		//System.out.println(hyouka+" "+approved+" "+id);

		Report rep = repRepository.findByReId(Integer.parseInt(id));
		Repcomment data = new Repcomment(rep,hyouka);
		repcommentRepository.save(data);

		if(approved.equals("0")) {
			//System.out.println("a");
			rep.setUNSUBMIT(0);
			rep.setSUBMITTED(1);
		}else if(approved.equals("1")) {
			rep.setUNSUBMIT(0);
			rep.setRESUBMIT(1);
		}
		repRepository.save(rep);
		deniedApp(model);
		return "teacheres/application/list";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(Model model,@RequestParam("name") String name,@RequestParam("depart") String depart,@RequestParam("year") String year,@RequestParam("class") String room,@RequestParam("company") String company) {
		//if(name == "") {System.out.println("ゼロ文字やで～");}
		if(name != "") {
			if(depart != "") {
				if(year != "") {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByStrict(name,depart,Integer.parseInt(year),room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutCompany(name,depart,Integer.parseInt(year),room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutRoom(name,depart,Integer.parseInt(year),company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutRoomCompany(name,depart,Integer.parseInt(year)));
						}
					}
				}else {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutYear(name,depart,room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutYearCompany(name,depart,room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutYearRoom(name,depart,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutYearRoomCompany(name,depart));
						}
					}
				}
			}else {
				if(year != "") {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutDepart(name,Integer.parseInt(year),room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutDepartCompany(name,Integer.parseInt(year),room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutDepartRoom(name,Integer.parseInt(year),company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutDepartRoomCompany(name,Integer.parseInt(year)));
						}
					}
				}else {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutDepartYear(name,room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutDepartYearCompany(name,room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutDepartYearRoom(name,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutDepartYearRoomCompany(name));
						}
					}
				}
			}
		}else {
			if(depart != "") {
				if(year != "") {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutName(depart,Integer.parseInt(year),room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameCompany(depart,Integer.parseInt(year),room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameRoom(depart,Integer.parseInt(year),company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameRoomCompany(depart,Integer.parseInt(year)));
						}
					}
				}else {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameYear(depart,room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameYearCompany(depart,room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameYearRoom(depart,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameYearRoomCompany(depart));
						}
					}
				}
			}else {
				if(year != "") {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameDepart(Integer.parseInt(year),room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameDepartCompany(Integer.parseInt(year),room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameDepartRoom(Integer.parseInt(year),company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameDepartRoomCompany(Integer.parseInt(year)));
						}
					}
				}else {
					if(room != "") {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameDepartYear(room,company));
						}else {
							model.addAttribute("Datas",appRepository.findByOutNameDepartYearCompany(room));
						}
					}else {
						if(company != "") {
							model.addAttribute("Datas",appRepository.findByOutNameDepartYearRoom(company));
						}else {
							model.addAttribute("Datas",appRepository.findAll());
						}
					}
				}
			}
		}
		//model.addAttribute("Datas",appRepository.findByNAME(name));




		return "search/result";
	}




}