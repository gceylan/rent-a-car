package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.BranchDao;
import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchDao branchDao;

	@Transactional
	public void addBranch(Branch branch) {
		branchDao.addBranch(branch);
	}

	@Transactional
	public Branch getBranchById(Integer branchId) {
		return branchDao.getBranchById(branchId);
	}

	@Transactional
	public void updateBranch(Branch branch) {
		branchDao.updateBranch(branch);
	}

	@Transactional
	public void deleteBranch(Integer branchId) {
		branchDao.deleteBranch(branchId);
	}

	@Transactional
	public List<Branch> getAllBranchs() {
		return branchDao.getAllBranchs();
	}
	
	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}

}
