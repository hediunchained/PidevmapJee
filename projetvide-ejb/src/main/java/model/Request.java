package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Requests database table.
 * 
 */
@Entity
@Table(name="Requests")
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RequestID")
	private int requestID;

	@Column(name="ClientId")
	private int clientId;

	@Column(name="Deposit_date")
	private String deposit_date;

	@Column(name="Deposit_hour")
	private String deposit_hour;

	@Column(name="Education")
	private String education;

	@Column(name="MandateFinish_date")
	private String mandateFinish_date;

	@Column(name="Mandatestart_Date")
	private String mandatestart_Date;

	@Column(name="Price")
	private int price;

	@Column(name="Requirements")
	private String requirements;

	@Column(name="YearsExperience")
	private int yearsExperience;
	
	@Column(name="ProjectName")
	private String projectname;
	
	@Column(name="ClientName")
	private String clientname;
	
	@Column(name="ProjetID")
	private String projectId;
	
	

	//bi-directional many-to-one association to Projet
//	@ManyToOne
//	@JoinColumn(name="Project_ProjetID")
//	private Projet projet;

	public Request() {
	}

	public int getRequestID() {
		return this.requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	

	public String getDeposit_date() {
		return deposit_date;
	}

	public void setDeposit_date(String deposit_date) {
		this.deposit_date = deposit_date;
	}

	public String getDeposit_hour() {
		return deposit_hour;
	}

	public void setDeposit_hour(String deposit_hour) {
		this.deposit_hour = deposit_hour;
	}

	public String getMandateFinish_date() {
		return mandateFinish_date;
	}

	public void setMandateFinish_date(String mandateFinish_date) {
		this.mandateFinish_date = mandateFinish_date;
	}

	public String getMandatestart_Date() {
		return mandatestart_Date;
	}

	public void setMandatestart_Date(String mandatestart_Date) {
		this.mandatestart_Date = mandatestart_Date;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRequirements() {
		return this.requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public int getYearsExperience() {
		return this.yearsExperience;
	}

	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
}