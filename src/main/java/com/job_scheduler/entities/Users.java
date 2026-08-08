package com.job_scheduler.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users{
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long user_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique = true, nullable = false, updatable = true )
	private String email;
	
	@Column(name = "mobile_no", unique = true, nullable = false, updatable = true)
	private String mobileNo;
	
	@Column(name = "password", nullable = false, updatable = true)
	private String password;
	
	public Users(String name, String email, String mobileNo, String password){
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	
	
}