package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Admin;
import org.hcl.entities.Policy;

public interface AdminDAO {

	public boolean save(Admin admin);

	public Admin login(Admin admin);

	public boolean savepolicy(Policy policy);

	public List<Policy> getAllPolicies();

	public Policy getPolicy(Integer pid);

	public boolean editPolicy(Policy policy);

	public boolean deletePolicy(Integer Pid);

}
