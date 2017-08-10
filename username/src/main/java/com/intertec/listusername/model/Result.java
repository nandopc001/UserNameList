package com.intertec.listusername.model;

import java.util.List;

public class Result {
	private boolean valid;
	private List<String> sugestion;
	private String messsage;
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	/**
	 * @return the sugestion
	 */
	public List<String> getSugestion() {
		return sugestion;
	}
	/**
	 * @param sugestion the sugestion to set
	 */
	public void setSugestion(List<String> sugestion) {
		this.sugestion = sugestion;
	}
	/**
	 * @return the messsage
	 */
	public String getMesssage() {
		return messsage;
	}
	/**
	 * @param messsage the messsage to set
	 */
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
}
