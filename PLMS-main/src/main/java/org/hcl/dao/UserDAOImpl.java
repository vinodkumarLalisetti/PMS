package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Admin;
import org.hcl.entities.Policy;
import org.hcl.entities.PolicyPayment;
import org.hcl.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			session.save(user);
			return true;
		} catch (Exception e) {
			System.out.println("Error occured during insertion " + e.getMessage());
			return false;
		}
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User us = null;
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			// session.beginTransaction(); // not required for select
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("from User a");
			List<User> resultList = query.list();
			for (User a : resultList) {
				if (a.getUsername().equals(user.getUsername()) && a.getPassword().equals(user.getPassword())) {
					us = a;
					break;
				}
			}
			return us;
		} catch (Exception e) {
			System.out.println("Error occured during select " + e.getMessage());
			return us;
		}
	}

	@Override
	public List<Policy> getPolicies(String key, String value) {
		// TODO Auto-generated method stub
		List<Policy> results=null;
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			String hql = null;
			Integer v = null;
			if (key.equals("pid")) {
				hql = "FROM Policy P WHERE P.pid = :value1";
				v = Integer.parseInt(value);
			} else if (key.equals("policyName"))
				hql = "FROM Policy P WHERE P.policyName = :value1";
			else if (key.equals("policyType"))
				hql = "FROM Policy P WHERE P.policyType = :value1";
			else if (key.equals("duration")) {
				hql = "FROM Policy P WHERE P.duration = :value1";
				v = Integer.parseInt(value);
			} else if (key.equals("companyName"))
				hql = "FROM Policy P WHERE P.companyName = :value1";
			Query query = session.createQuery(hql);
			if (key.equals("pid") || key.equals("duration"))
				query.setParameter("value1", v);
			else
				query.setParameter("value1", value);
			results = query.list();
			// Query query = session.createQuery("from Policy a");

		} catch (Exception e) {
			System.out.println("Error occured during select " + e.getMessage());
		}
		return results;
	}

	@Transactional
	@Override
	public PolicyPayment setPayment(PolicyPayment payment) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getSessionFactory().openSession();
		try {
			session.save(payment);
		} catch (Exception e) {
			String hql = "FROM PolicyPayment P WHERE P.policyid = :value";
			Query query = session.createQuery(hql);
			query.setParameter("value", payment.getPolicyid());
			List<PolicyPayment> results = query.list();
			return results.get(0);
		}
		String hql = "FROM PolicyPayment P WHERE P.policyid = :value";
		Query query = session.createQuery(hql);
		query.setParameter("value", payment.getPolicyid());
		List<PolicyPayment> results = query.list();
		return results.get(0);
	}

	@Transactional
	@Override
	public boolean proceedToPay(Integer payid) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			String hqlUpdate = "update PolicyPayment P set P.status = :value where P.payid = :payValue";
			int updatedEntities = session.createQuery(hqlUpdate).setString("value", "success")
					.setInteger("payValue", payid).executeUpdate();
			tx.commit();
			if (updatedEntities > 0)
				return true;
		} catch (Exception e) {
			System.out.println("Error occured during insertion " + e.getMessage());
			return false;
		}
		return false;
	}

}