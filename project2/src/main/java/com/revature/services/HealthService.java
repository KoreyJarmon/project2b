package com.revature.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Health;
import com.revature.repos.HealthRepo;

@Service
public class HealthService {
	
	@Autowired
	private HealthRepo hr;
	
	public Health findByHealthLabel(String health) {
		return hr.findByHealthLabel(health);
	}

}
