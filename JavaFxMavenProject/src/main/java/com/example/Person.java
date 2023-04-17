package com.example;

import javafx.scene.control.Button;

public class Person {
	public Person(Integer id, String username, Button available) {
		super();
		this.id = id;
		this.username = username;
		this.available = available;
	}
	private Integer id;
	private String username;
	private Button available;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Button getAvailable() {
		return available;
	}
	public void setAvailable(Button available) {
		this.available = available;
	}
}
