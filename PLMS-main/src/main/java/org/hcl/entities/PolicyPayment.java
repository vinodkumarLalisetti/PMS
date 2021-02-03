package org.hcl.entities;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PolicyPayment")
public class PolicyPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payid;
	@Column(unique = true, nullable = false)
	private Integer policyid;
	private Integer uid;
	@Column(columnDefinition = "Date default '2020-12-25'")
	private Date billDate;
	@Column(columnDefinition = "Date default '2021-01-10'")
	private Date dueDate;
	private Integer amount;
	private Integer fine;
	@Column(columnDefinition = "varchar(10) default 'pending'")
	private String status;

	public PolicyPayment() {
		// TODO Auto-generated constructor stub
	}

	public PolicyPayment(Integer payid, Integer policyid, Integer uid, Date billDate, Date dueDate, Integer amount,
			Integer fine, String status) {
		super();
		this.payid = payid;
		this.policyid = policyid;
		this.uid = uid;
		this.billDate = billDate;
		this.dueDate = dueDate;
		this.amount = amount;
		this.fine = fine;
		this.status = status;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPayid() {
		return payid;
	}

	public void setPayid(Integer payid) {
		this.payid = payid;
	}

	public Integer getPolicyid() {
		return policyid;
	}

	public void setPolicyid(Integer policyid) {
		this.policyid = policyid;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}