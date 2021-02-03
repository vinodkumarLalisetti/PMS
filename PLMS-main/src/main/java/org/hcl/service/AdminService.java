package org.hcl.service;

import java.util.List;

import org.hcl.entities.Admin;
import org.hcl.entities.Policy;

public interface AdminService {

	public Admin login(Admin admin);

	public boolean register(Admin admin);

	public boolean createPolicy(Policy policy);

	public List<Policy> getAllPolicies();

	public Policy getPolicy(Integer pid);

	public boolean editPolicy(Policy policy);

	public boolean deletePolicy(Integer pid);
}