package com.vitos.pizza.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

/**
 * The Class Customer.
 */
@Entity
@Table(name = "customer")
public class Customer {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The fname. */
	@NonNull
	private String fname;

	/** The lname. */
	@NonNull
	private String lname;

	/** The phone. */
	@NonNull
	private String phone;

	/** The email. */
	@NonNull
	private String email;

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
		super();
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param id    the id
	 * @param fname the fname
	 * @param lname the lname
	 * @param phone the phone
	 * @param email the email
	 */
	public Customer(Long id, String fname, String lname, String phone, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param fname the fname
	 * @param lname the lname
	 * @param phone the phone
	 * @param email the email
	 */
	public Customer(String fname, String lname, String phone, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the fname.
	 *
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * Sets the fname.
	 *
	 * @param fname the new fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * Gets the lname.
	 *
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * Sets the lname.
	 *
	 * @param lname the new lname
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
