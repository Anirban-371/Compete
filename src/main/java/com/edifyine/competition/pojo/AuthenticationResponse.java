package com.edifyine.competition.pojo;

import lombok.Data;

@Data
public class AuthenticationResponse {

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	String jwt;
}
