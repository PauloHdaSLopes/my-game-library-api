package br.com.home.gameLibrary.controller.dto;

public class TokenDto {

	private String token;
	private String string;

	public TokenDto(String token, String string) {
		this.token = token;
		this.string = string;
	}

	public String getToken() {
		return token;
	}

	public String getString() {
		return string;
	}

}
