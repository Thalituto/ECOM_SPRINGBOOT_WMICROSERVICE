package com.example.demo.service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Profile;
import com.example.demo.entities.Role;

import java.util.List;

public interface IService {

	public Account addAccount (Account acc);
	public Profile addProfile( Profile p, long idacc);
	public Role  addRole(Role r);
	public Account addRole2Account(Role r,long idacc);

	public Account addProfile2Account(long idc,long idp);
	
	
	public Account findAccountbyId (long id);
	public Profile findProfilebyId(long idp);
	public List<Profile> findProfile ();
}
