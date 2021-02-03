package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Policy;
import org.hcl.entities.PolicyPayment;
import org.hcl.entities.User;

public interface UserDAO {

	public boolean save(User user);

	public User login(User user);

	public List<Policy> getPolicies(String key, String value);

	public PolicyPayment setPayment(PolicyPayment payment);

	public boolean proceedToPay(Integer payid);
}