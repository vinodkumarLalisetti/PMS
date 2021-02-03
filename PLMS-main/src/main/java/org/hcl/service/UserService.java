package org.hcl.service;

import java.util.List;

import org.hcl.entities.Policy;
import org.hcl.entities.PolicyPayment;
import org.hcl.entities.User;

public interface UserService {

	public User login(User user);

	public boolean register(User user);

	public List<Policy> getPolicies(String key, String value);

	public PolicyPayment setPolicy(PolicyPayment payment);

	public boolean proccedToPay(Integer payid);
}