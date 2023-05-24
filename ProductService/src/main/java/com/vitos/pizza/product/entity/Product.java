package com.vitos.pizza.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * The Class Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 473881289988114723L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	/** The name. */
	@NonNull
	private String name;

	/** The description. */
	@Nullable
	private String description;

	/** The quantity. */
	@NonNull
	private int quantity;

	/** The price. */
	@NonNull
	private double price;

	/** The catagory. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "catagory_id", nullable = false)
	private Catagory catagory;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
		super();
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 * @param name the name
	 * @param description the description
	 * @param quantity the quantity
	 * @param price the price
	 * @param catagory the catagory
	 */
	public Product(Long id, String name, String description, int quantity, double price, Catagory catagory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.catagory = catagory;
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 * @param description the description
	 * @param quantity the quantity
	 * @param price the price
	 * @param catagory the catagory
	 * @param orderDetails the order detail
	 */
	public Product(String name, String description, int quantity, double price, Catagory catagory) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.catagory = catagory;
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

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the catagory.
	 *
	 * @return the catagory
	 */
	public Catagory getCatagory() {
		return catagory;
	}

	/**
	 * Sets the catagory.
	 *
	 * @param catagory the new catagory
	 */
	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

}
