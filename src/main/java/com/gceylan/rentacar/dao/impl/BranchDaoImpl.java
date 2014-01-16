package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.BranchDao;
import com.gceylan.rentacar.domain.Branch;

@Repository
public class BranchDaoImpl implements BranchDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addBranch(Branch branch) {
		getSession().save(branch);
	}

	public Branch getBranchById(Integer branchId) {
		return (Branch) getSession().get(Branch.class, branchId);
	}

	public void updateBranch(Branch branch) {
		getSession().update(branch);
	}

	public void deleteBranch(Integer branchId) {
		getSession().delete(getBranchById(branchId));
	}

	@SuppressWarnings("unchecked")
	public List<Branch> getAllBranchs() {
		return (List<Branch>) getSession().createCriteria(Branch.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
