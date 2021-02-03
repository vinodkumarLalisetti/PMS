package org.hcl.service;

import java.sql.Date;
import java.util.List;

import org.hcl.dao.UserDAO;
import org.hcl.entities.Policy;
import org.hcl.entities.PolicyPayment;
import org.hcl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userdao;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userdao.login(user);
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}

	@Override
	public List<Policy> getPolicies(String key, String value) {
		// TODO Auto-generated method stub
		return userdao.getPolicies(key, value);
	}

	@Override
	public PolicyPayment setPolicy(PolicyPayment payment) {
		// TODO Auto-generated method stub
		payment.setBillDate(Date.valueOf("2020-12-20"));
		payment.setDueDate(Date.valueOf("2021-01-10"));
		payment.setFine(0);
		payment.setStatus("pending");
		return userdao.setPayment(payment);
	}

	@Override
	public boolean proccedToPay(Integer payid) {
		// TODO Auto-generated method stub
		return userdao.proceedToPay(payid);
	}

}
