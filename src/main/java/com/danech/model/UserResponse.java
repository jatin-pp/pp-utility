package com.danech.model;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

/**
 * DTO class used to give UserResponse for token
 * @author dev77
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	public UserResponse(String string, String token2) {
		// TODO Auto-generated constructor stub
	}
	private String message;

	private String token;
}
