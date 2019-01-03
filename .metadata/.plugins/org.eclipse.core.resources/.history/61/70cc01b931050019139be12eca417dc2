package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CustomRoles database table.
 * 
 */
@Entity
@Table(name="CustomRoles")
@NamedQuery(name="CustomRole.findAll", query="SELECT c FROM CustomRole c")
public class CustomRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Name")
	private Object name;

	public CustomRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

}