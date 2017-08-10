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

/**
 * @author nandopc001
 *
 */
@Table(name="WORD_RESTRICT")
@NamedQuery(name="WordRestrict.findAll", query="SELECT w FROM WordRestrict w")
@Entity
public class WordRestrict {
	
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String word;

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
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

}
