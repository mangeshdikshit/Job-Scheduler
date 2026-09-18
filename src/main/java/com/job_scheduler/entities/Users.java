package com.job_scheduler.entities;

import com.job_scheduler.models.UserRoles;
import jakarta.persistence.*;
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
	private long userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique = true, nullable = false, updatable = true )
	private String email;
	
	@Column(name = "mobile_no", unique = true, nullable = false, updatable = true)
	private String mobileNo;
	
	@Column(name = "password", nullable = false, updatable = true)
	private String password;

	@Column(name = "user_role", nullable = false, updatable = true)
	@Enumerated(EnumType.STRING)
	private UserRoles userRole;
	
	public Users(String name, String email, String mobileNo, String password, UserRoles userRole){
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.userRole = userRole;
	}
	
	
}