package com.ty.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;

@Component
public class BranchDaoImplementation implements BranchDao{

	@Autowired
	private EntityManager manager;
	
	@Override
	public Branch saveBranch(Branch branch) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(branch);
		transaction.commit();
		return branch;
	}

	@Override
	public Branch updateBranch(Branch branch) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(branch);
		transaction.commit();
		return branch;
	}

	@Override
	public boolean deleteBranch(Branch branch) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(branch);
		transaction.commit();
		return true;
	}

	@Override
	public Branch findBranch(int id) {
		return manager.find(Branch.class, id);
	}

	@Override
	public List<Branch> findAllBranch() {
		// TODO Auto-generated method stub
		Query query=manager.createQuery("select b from Branch b");
		return query.getResultList();
	}

}
