package com.seedsystem.common.model;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchRequest {
	
	private String state;
	private String county;
	private List<String> crops;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public List<String> getCrops() {
		return crops;
	}
	public void setCrops(List<String> crops) {
		this.crops = crops;
	}
	
	

}
