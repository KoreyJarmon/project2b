package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "health_label_table")

public class Health {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "health_label_id")
	private int healthLabelId;

	@Column(name = "health_label")
	private String healthLabel;

	public Health() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Health(int healthLabelId, String healthLabel) {
		super();
		this.healthLabelId = healthLabelId;
		this.healthLabel = healthLabel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((healthLabel == null) ? 0 : healthLabel.hashCode());
		result = prime * result + healthLabelId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Health other = (Health) obj;
		if (healthLabel == null) {
			if (other.healthLabel != null)
				return false;
		} else if (!healthLabel.equals(other.healthLabel))
			return false;
		if (healthLabelId != other.healthLabelId)
			return false;
		return true;
	}

	public int getHealthLabelId() {
		return healthLabelId;
	}

	public void setHealthLabelId(int healthLabelId) {
		this.healthLabelId = healthLabelId;
	}

	public String getHealthLabel() {
		return healthLabel;
	}

	public void setHealthLabel(String healthLabel) {
		this.healthLabel = healthLabel;
	}

	@Override
	public String toString() {
		return "Health [healthLabelId=" + healthLabelId + ", healthLabel=" + healthLabel + "]";
	}

}
