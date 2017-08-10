/**
 * 
 */
package com.intertec.listusername.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author nandopc001
 *
 */
@Table(name="USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Size(min=6,message="Username must be at least 6 characters long.")
	@Column(unique = true, nullable = false)
	private String name;
	
	public User(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
