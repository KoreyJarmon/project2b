package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Health;

public interface HealthRepo extends JpaRepository <Health, Integer>{

	Health findByHealthLabel(String health);

}
