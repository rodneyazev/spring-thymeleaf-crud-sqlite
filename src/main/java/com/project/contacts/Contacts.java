package com.project.contacts;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="contacts_project")
@SequenceGenerator(name = "contacts_project_seq", sequenceName="next_val")
public class Contacts implements Serializable{

		private static final long serialVersionUID = 1L;
		
		@Id @GeneratedValue(strategy=GenerationType.TABLE, generator="contacts_project_seq")
		@Column(name="id")
		private int id;
		
		private String name;
		private String id_personal;
		private String position;
		private String phone;
		private String email;
		private String department;
		private String unit;
		private String observation;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId_personal() {
			return id_personal;
		}
		public void setId_personal(String id_personal) {
			this.id_personal = id_personal;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public String getObservation() {
			return observation;
		}
		public void setObservation(String observation) {
			this.observation = observation;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
