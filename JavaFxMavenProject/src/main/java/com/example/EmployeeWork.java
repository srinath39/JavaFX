package com.example;

import javafx.scene.control.Button;

public class EmployeeWork {
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public int getWhours() {
		return whours;
	}
	public void setWhours(int whours) {
		this.whours = whours;
	}
	public int getNwhours() {
		return nwhours;
	}
	public void setNwhours(int nwhours) {
		this.nwhours = nwhours;
	}
	private String weekday;
	private int whours;
	private int nwhours;
	public EmployeeWork(String weekday, int whours, int nwhours) {
		super();
		this.weekday = weekday;
		this.whours = whours;
		this.nwhours = nwhours;
	}
}

