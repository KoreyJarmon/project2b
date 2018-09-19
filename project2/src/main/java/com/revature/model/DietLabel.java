//package com.revature.model;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;
//
//@Entity
//@Table(name = "diet_label_table")
//public class DietLabel {
//	@Column(name = "diet_label_id")
//	private String dietLabelId;
//	@Column(name = "diet_label")
//	private String dietLabel;
//
////	@OneToMany(mappedBy = "dietLabel")
////	private List<Recipe> recipe;
//	public DietLabel() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public DietLabel(String dietLabelId, String dietLabel) {
//		super();
//		this.dietLabelId = dietLabelId;
//		this.dietLabel = dietLabel;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((dietLabel == null) ? 0 : dietLabel.hashCode());
//		result = prime * result + ((dietLabelId == null) ? 0 : dietLabelId.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DietLabel other = (DietLabel) obj;
//		if (dietLabel == null) {
//			if (other.dietLabel != null)
//				return false;
//		} else if (!dietLabel.equals(other.dietLabel))
//			return false;
//		if (dietLabelId == null) {
//			if (other.dietLabelId != null)
//				return false;
//		} else if (!dietLabelId.equals(other.dietLabelId))
//			return false;
//		return true;
//	}
//
//	public String getDietLabelId() {
//		return dietLabelId;
//	}
//
//	public void setDietLabelId(String dietLabelId) {
//		this.dietLabelId = dietLabelId;
//	}
//
//	public String getDietLabel() {
//		return dietLabel;
//	}
//
//	public void setDietLabel(String dietLabel) {
//		this.dietLabel = dietLabel;
//	}
//
//	@Override
//	public String toString() {
//		return "DietLabel [dietLabelId=" + dietLabelId + ", dietLabel=" + dietLabel + "]";
//	}
//
//}
