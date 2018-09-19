package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.HealthService;

@RestController
@RequestMapping("health")
public class HealthController {
	
	@Autowired
	private HealthService hs;
	
	// /health/:label
	@GetMapping("{label}")
	public int findByHealthLabel(@PathVariable String label){
		return hs.findByHealthLabel(label).getHealthLabelId();
	}

}
