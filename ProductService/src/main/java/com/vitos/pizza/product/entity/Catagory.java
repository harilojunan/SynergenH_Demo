package com.vitos.pizza.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * The Class Category.
 */
@Entity
@Table(name = "catagory")
public class Catagory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7538607815731664734L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private long id;

	/** The name. */
	@NonNull
	private String name;

	/** The description. */
	@Nullable
	private String description;

	/**
	 * Instantiates a new category.
	 */
	public Catagory() {
		super();
	}

	/**
	 * Instantiates a new catagory.
	 *
	 * @param id the id
	 * @param name the name
	 * @param description the description
	 */
	public Catagory(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * Instantiates a new catagory.
	 *
	 * @param name the name
	 * @param description the description
	 */
	public Catagory(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
