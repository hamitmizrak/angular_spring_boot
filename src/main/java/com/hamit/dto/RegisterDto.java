package com.hamit.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Builder
public class RegisterDto implements Serializable {
	private static final long serialVersionUID = -8469172557799125934L;
	
	private int registerId;
	private String registerName;
	private String registerSurname;
	private String registerEmail;
	private String registerPassword;
	
}
