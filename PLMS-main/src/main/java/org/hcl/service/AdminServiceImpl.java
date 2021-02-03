package org.hcl.service;

import java.util.List;

import org.hcl.dao.AdminDAO;
import org.hcl.entities.Admin;
import org.hcl.entities.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO admindao;

	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.login(admin);
	}

	@Override
	public boolean register(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.save(admin);
	}

	@Override
	public boolean createPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return admindao.savepolicy(policy);
	}

	@Override
	public List<Policy> getAllPolicies() {
		// TODO Auto-generated method stub
		return admindao.getAllPolicies();
	}

	@Override
	public boolean editPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return admindao.editPolicy(policy);
	}

	@Override
	public boolean deletePolicy(Integer pid) {
		// TODO Auto-generated method stub
		return admindao.deletePolicy(pid);
	}

	@Override
	public Policy getPolicy(Integer pid) {
		// TODO Auto-generated method stub
		return admindao.getPolicy(pid);
	}
}