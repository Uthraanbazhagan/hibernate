package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="TBL_PAYMENT")

public class Payment {
    @Id
    @GeneratedValue
    @Column(name="P_ID")
	private int id;
	private int amount;
	private String pmode;
	private Status pstatus;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	public Status getPstatus() {
		return pstatus;
	}
	public void setPstatus(Status pstatus) {
		this.pstatus = pstatus;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
