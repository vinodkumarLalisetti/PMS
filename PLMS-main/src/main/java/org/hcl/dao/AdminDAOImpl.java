package org.hcl.dao;

import java.util.List;

import org.hcl.entities.Admin;
import org.hcl.entities.Policy;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	@Transactional
	public boolean save(Admin admin) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			session.save(admin);
			return true;
		} catch (Exception e) {
			System.out.println("Error occured during insertion " + e.getMessage());
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		Admin ad = null;

		try {
			Session session = sessionfactory.getSessionFactory().openSession();

			// session.beginTransaction(); // not required for select
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("from Admin a");
			List<Admin> resultList = query.list();
			for (Admin a : resultList) {
				if (a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())) {
					ad = a;
					break;
				}
			}
			return ad;
		} catch (Exception e) {
			System.out.println("Error occured during select " + e.getMessage());
			return ad;
		}
	}

	@Override
	@Transactional
	public boolean savepolicy(Policy policy) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			session.save(policy);
			return true;
		} catch (Exception e) {
			System.out.println("Error occured during insertion " + e.getMessage());
			return false;
		}
	}

	@Override
	public Policy getPolicy(Integer pid) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();

			String hql = "FROM Policy P WHERE P.pid = :pid";
			Query query = session.createQuery(hql);
			query.setParameter("pid", pid);
			List results = query.list();
			return (Policy) results.get(0);
		} catch (Exception e) {
			System.out.println("Error occured during insertion " + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Policy> getAllPolicies() {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Policy.class);
			List<Policy> resultList = cr.list();
			// Query query = session.createQuery("from Policy a");
			return resultList;
		} catch (Exception e) {
			System.out.println("Error occured during select " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public boolean editPolicy(Policy policy) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(policy);
			tx.commit();
			return true;
		} catch (Exception e) {
			System.out.println("Error occured during insertion " + e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	// @Transactional
	public boolean deletePolicy(Integer pid) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionfactory.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			/*
			 * Query query = session.createQuery("delete from Policy where pid = :ppid");
			 * query.setParameter("ppid", pid); int result = query.executeUpdate();
			 */

			Object persistentInstance = session.load(Policy.class, pid);
			if (persistentInstance != null) {
				session.delete(persistentInstance);
			}
			/*
			 * if (result > 0) { System.out.println("policy was removed"); return true; }
			 */
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured during deleting \n");
			return false;
		}
	}

}