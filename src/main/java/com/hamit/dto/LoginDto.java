package com.hamit.dto;

import java.io.Serializable;

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

public class LoginDto implements Serializable {
	private static final long serialVersionUID = -3190006057185856173L;
	
	// field Nesne degiskenleri
	private int loginId;
	private String loginEmailAddres;
	private String loginUserName;
	private String loginPassword;
}
