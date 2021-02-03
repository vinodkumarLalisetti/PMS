package org.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hcl.entities.Admin;
import org.hcl.entities.Policy;
import org.hcl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping("/home")
	public ModelAndView showAdminhome() {
		return new ModelAndView("home");
	}

	@RequestMapping("/register")
	public String showAdminRegistration() {
		return "/admin_registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveAdmin(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("age") Integer age,
			@RequestParam("gender") String gender, @RequestParam("phonenumber") String phonenumber,
			@RequestParam("username") String vendorid, @RequestParam("password") String password) {
		Admin admin = new Admin(firstname, lastname, gender, age, phonenumber, vendorid, password);
		if (adminService.register(admin)) {
			return new ModelAndView("registerSuccess");

		} else
			return new ModelAndView("registerFailure");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		Admin us = adminService.login(admin);
		if (us != null) {
			session.setAttribute("user", us);
			session.setAttribute("person", "admin");
			return new ModelAndView("loginSuccess");
		} else {
			// modelMap.put("error", "Invalid Account");
			return new ModelAndView("loginFailure");
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("person");
		return "redirect:../";
	}

	@RequestMapping(value = "/createpolicy", method = RequestMethod.GET)
	public ModelAndView showPolicyRegistration() {
		return new ModelAndView("policy_registration");
	}

	@RequestMapping(value = "/policyregistration", method = RequestMethod.POST)
	public ModelAndView saveAdmin(@RequestParam("policyname") String policyname,
			@RequestParam("policytype") String policytype, @RequestParam("policyduration") Integer duration,
			@RequestParam("policyamount") Integer amount, @RequestParam("companyname") String companyname) {
		Policy policy = new Policy(policyname, policytype, duration, amount, companyname);
		if (adminService.createPolicy(policy)) {

			return new ModelAndView("policyRegisterSuccess").addObject("policyName", policyname);

		} else
			return new ModelAndView("policyRegisterFailure");
	}

	@RequestMapping(value = "/updatepolicy", method = RequestMethod.GET)
	public ModelAndView showUpdatePolicy() {
		List<Policy> policies = adminService.getAllPolicies();
		return new ModelAndView("update_policy").addObject("policies", policies);
	}

	@RequestMapping(value = "/editpolicy", method = RequestMethod.POST)
	public ModelAndView getEditPolicy(@RequestParam("pid") Integer pid, @RequestParam("policyname") String policyname,
			@RequestParam("policytype") String policytype, @RequestParam("policyduration") Integer duration,
			@RequestParam("policyamount") Integer amount, @RequestParam("companyname") String companyname, Model m) {
		
		Policy policy = new Policy(pid, policyname, policytype, duration, amount, companyname);

		if (adminService.editPolicy(policy)) {
			m.addAttribute("policy", policy);
			return new ModelAndView("home");
		} else
			return new  ModelAndView("editpolicyFailure");

	}

	@RequestMapping(value = "/editpolicy", method = RequestMethod.GET)
	public ModelAndView postEditPolicy(@RequestParam("pid") Integer pid, Model m) {
		Policy policy = adminService.getPolicy(pid);
		m.addAttribute("policy", policy);
		return new ModelAndView("edit_policy");
	}

	@RequestMapping(value = "/deletepolicy", method = RequestMethod.GET)
	public ModelAndView deletePolicy(@RequestParam("pid") Integer pid, Model m) {
		if (adminService.deletePolicy(pid))
			return new ModelAndView("home");
		else
			return new ModelAndView("deletepolicyFailure");
	}

}