package com.example.model;

public class Success {
	private int successCode;
	private String successMessge;

	public Success(int successCode, String successMessge) {
		super();
		this.successCode = successCode;
		this.successMessge = successMessge;
	}

	public int getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(int successCode) {
		this.successCode = successCode;
	}

	public String getSuccessMessge() {
		return successMessge;
	}

	public void setSuccessMessge(String successMessge) {
		this.successMessge = successMessge;
	}

	@Override
	public String toString() {
		return "Success [successCode=" + successCode + ", successMessge=" + successMessge + "]";
	}

}