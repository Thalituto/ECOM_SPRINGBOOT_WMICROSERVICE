package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repos.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Profile;
import com.example.demo.entities.Role;
import com.example.demo.repos.IAccount;
import com.example.demo.repos.IProfile;

@Service
public class ServiceCustomer implements IService{

	@Autowired
	IAccount arepo;
	@Autowired
	IProfile prepo;
	@Autowired
	IRole rrepo;
	@Override
	public Account addAccount(Account acc) {
		// TODO Auto-generated method stub
		return arepo.save(acc);
	}

	@Override
	public Profile addProfile(Profile p, long idacc) {
		Account ac = arepo.findById(idacc).orElseThrow();
		p.setAccount(ac);
		p=prepo.save(p);
		return p;
	}

	@Override
	public Role addRole(Role r) {
		// TODO Auto-generated method stub
		return rrepo.save(r);
	}

	@Override
	public Account addRole2Account(Role r,long idacc) {

		return null;

	}

	@Override
	public Account addProfile2Account(long idc, long idp) {

		Account c = arepo.findById(idc).orElseThrow();
		Profile p=prepo.findById(idp).orElseThrow();
		c.setProfile(p);
		c=arepo.save(c);

		return c;
	}

	@Override
	public Account findAccountbyId(long id) {

		return  arepo.findById(id).orElseThrow();
	}

	@Override
	public Profile findProfilebyId(long idp) {
		return prepo.findById(idp).orElseThrow();
	}

	@Override
	public List<Profile> findProfile() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}
