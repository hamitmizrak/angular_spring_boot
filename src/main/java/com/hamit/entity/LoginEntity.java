package com.hamit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NonNull

// Entity
@Entity
@Table(name = "login")
public class LoginEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -5873084054081369057L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id", updatable = false)
	private int loginId;
	
	@Column(name = "login_email_address", unique = true, length = 150)
	private String loginEmailAddres;
	
	@Column(name = "login_user_name", unique = true, length = 150)
	private String loginUserName;
	
	@Column(name = "login_user_password", unique = true, length = 450)
	private String loginPassword;
	
}
