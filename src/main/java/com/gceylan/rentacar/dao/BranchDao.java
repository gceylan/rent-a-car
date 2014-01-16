package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Branch;

public interface BranchDao {
	
	public void addBranch(Branch branch);
	
	public Branch getBranchById(Integer branchId);
	
	public void updateBranch(Branch branch);
	
	public void deleteBranch(Integer branchId);
	
	public List<Branch> getAllBranchs();

}
