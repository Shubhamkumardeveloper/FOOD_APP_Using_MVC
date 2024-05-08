package com.ty.dao;

import java.util.List;

import com.ty.dto.Branch;

public interface BranchDao {
	public Branch saveBranch(Branch branch);
	public Branch updateBranch(Branch branch);
	public boolean deleteBranch(Branch branch);
	public Branch findBranch(int id);
	public List<Branch> findAllBranch();

}
