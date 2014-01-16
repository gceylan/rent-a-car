package com.gceylan.rentacar.util;

import javax.validation.Valid;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;

public class AddBranchForm {
	
	@Valid
	public User manager;
	
	@Valid
	public Branch branch;

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "AddBranchForm [manager=" + manager + ", branch=" + branch + "]";
	}

}
