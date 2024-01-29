package com.example.demo.api;

import com.example.demo.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Account;
import com.example.demo.entities.Profile;
import com.example.demo.service.IService;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RefreshScope
public class CustomerApi {


@Autowired
	IService service;
	
	@PostMapping("/accounts")
	public Account addAccount( @RequestBody Account a)
	{
		return service.addAccount(a);
	}
	
	
	@GetMapping("/accounts/{id}")
	public Account findAccount(@PathVariable long id)
	{

		return service.findAccountbyId(id);
	}

	@GetMapping("/profiles/{idp}")
	public Profile findProfileByid(@PathVariable long idp){
		return service.findProfilebyId(idp);
	}

	@GetMapping("/profiles")
	public List<Profile> findProfile()
	{
		return service.findProfile();
	}
	
	
	@PostMapping("/accounts/{idac}/profiles")
	public Profile addprofile( @RequestBody Profile p, @PathVariable long idac)
	{

		return service.addProfile(p,idac);
	}

	@PostMapping("/profiles/{idp}/{idc}")
	public Account addProfile2Account(@PathVariable long idc,@PathVariable long idp){
		return service.addProfile2Account(idc,idp);
	}
}

