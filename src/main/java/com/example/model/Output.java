package com.example.model;

import java.util.List;

public class Output {
	private int data;
	private List<Success> successList;
	private List<Failure> failureList;
	

	public Output() {
		super();
	}


	public Output(int data, List<Success> successList, List<Failure> failureList) {
		super();
		this.data = data;
		this.successList = successList;
		this.failureList = failureList;
	}
	

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<Success> getSuccessList() {
		return successList;
	}

	public void setSuccessList(List<Success> successList) {
		this.successList = successList;
	}

	public List<Failure> getFailureList() {
		return failureList;
	}

	public void setFailureList(List<Failure> failureList) {
		this.failureList = failureList;
	}


	@Override
	public String toString() {
		return "Output [data=" + data + ", successList=" + successList + ", failureList=" + failureList + "]";
	}
}
