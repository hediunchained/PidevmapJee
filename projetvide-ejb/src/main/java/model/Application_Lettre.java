package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Application_Lettre database table.
 * 
 */
@Entity
@NamedQuery(name="Application_Lettre.findAll", query="SELECT a FROM Application_Lettre a")
public class Application_Lettre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApplicationID")
	private int applicationID;

	@Column(name="Date")
	private Date date;

	@Column(name="Resume")
	private String resume;

	@Column(name="Specialty")
	private String specialty;

	@Column(name="State")
	private String state;

	public Application_Lettre() {
	}

	public int getApplicationID() {
		return this.applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}