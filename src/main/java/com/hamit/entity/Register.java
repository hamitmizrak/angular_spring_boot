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

@Entity
@Table(name = "register")

@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Builder
public class Register extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4186656398944892347L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "register_id", updatable = false)
	private int registerId;
	
	@Column(name = "register_name", length = 150)
	private String registerName;
	
	@Column(name = "register_surname", length = 150)
	private String registerSurname;
	
	@Column(name = "register_email", length = 150)
	private String registerEmail;
	
	@Column(name = "register_password", length = 150)
	private String registerPassword;
	
}
