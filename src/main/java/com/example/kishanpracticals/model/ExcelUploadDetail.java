package com.example.kishanpracticals.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "excelupload")
public class ExcelUploadDetail {

	@Column(name = "Sr_No")
	private String srNo;

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "A")
	private String aA;

	@Column(name = "B")
	private String bB;

	@Column(name = "date")
	private String date;

	@Column(name = "C")
	private String cC;

	@Column(name = "D")
	private String dD;

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getaA() {
		return aA;
	}

	public void setaA(String aA) {
		this.aA = aA;
	}

	public String getbB() {
		return bB;
	}

	public void setbB(String bB) {
		this.bB = bB;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getcC() {
		return cC;
	}

	public void setcC(String cC) {
		this.cC = cC;
	}

	public String getdD() {
		return dD;
	}

	public void setdD(String dD) {
		this.dD = dD;
	}

}
