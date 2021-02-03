package org.hcl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Policy")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	@Column(unique = true, nullable = false)
	private String policyName;
	@Column(nullable = false)
	private String policyType;
	private Integer duration;
	private Integer amount;
	private String companyName;

	public Policy() {
		// TODO Auto-generated constructor stub
	}

	public Policy(Integer pid, String policyName, String policyType, Integer duration, Integer amount,
			String companyName) {
		super();
		this.pid = pid;
		this.policyName = policyName;
		this.policyType = policyType;
		this.duration = duration;
		this.amount = amount;
		this.companyName = companyName;
	}

	public Policy(String policyName, String policyType, Integer duration, Integer amount, String companyName) {
		super();
		this.policyName = policyName;
		this.policyType = policyType;
		this.duration = duration;
		this.amount = amount;
		this.companyName = companyName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}