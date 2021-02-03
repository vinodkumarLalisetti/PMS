package org.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hcl.entities.Policy;
import org.hcl.entities.PolicyPayment;
import org.hcl.entities.User;
import org.hcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/home")
	public ModelAndView showAdminhome() {
		return new ModelAndView("home");
	}

	@RequestMapping("/register")
	public String showAdminRegistration() {
		return "/user_registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveAdmin(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("age") Integer age,
			@RequestParam("gender") String gender, @RequestParam("phonenumber") String phonenumber,
			@RequestParam("username") String vendorid, @RequestParam("password") String password) {
		User user = new User(firstname, lastname, gender, age, phonenumber, vendorid, password);
		if (userService.register(user))
			return new ModelAndView("registerSuccess");
		else
			return new ModelAndView("registerFailure");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User us = userService.login(user);
		if (us != null) {
			session.setAttribute("user", us);
			session.setAttribute("person", "user");
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

	@RequestMapping(value = "/searchpolicy", method = RequestMethod.GET)
	public ModelAndView showSearcgPolicy() {
		return new ModelAndView("search_policy");
	}

	@RequestMapping(value = "/searchpolicy", method = RequestMethod.POST)
	public ModelAndView searcgPolicy(@RequestParam("policySearchBy") String key,
			@RequestParam("policySearchName") String value, Model m) {
		List<Policy> policies = userService.getPolicies(key, value);
		if (policies != null && !policies.isEmpty())
			m.addAttribute("policies", policies);
		else
			m.addAttribute("msg", "No Records were found in database based on your search criteria");

		return new ModelAndView("search_policy");
	}

	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public ModelAndView showPolicyPayment(@RequestParam("pid") Integer pid, @RequestParam("uid") Integer uid,
			@RequestParam Integer amount, Model m) {

		PolicyPayment pay = new PolicyPayment();
		pay.setPolicyid(pid);
		pay.setAmount(amount);
		pay.setUid(uid);
		PolicyPayment payment = userService.setPolicy(pay);

		m.addAttribute("pay", payment);
		return new ModelAndView("policy_payment");
	}

	@RequestMapping(value = "/proceedpay", method = RequestMethod.POST)
	public ModelAndView proceedPayment(@RequestParam("payid") Integer payid, Model m) {

		if (userService.proccedToPay(payid))
			return new ModelAndView("paymentSuccess");
		else
			return new ModelAndView("paymentFailure");
	}

	@RequestMapping(value = "/policypayment", method = RequestMethod.GET)
	public ModelAndView policyPayment() {
		return new ModelAndView("policypayment");
	}

}