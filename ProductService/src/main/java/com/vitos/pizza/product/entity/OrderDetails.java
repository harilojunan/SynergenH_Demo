package com.vitos.pizza.product.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;

/**
 * The Class Order.
 */
@Entity
@Table(schema = "productservices",name = "order_details")
public class OrderDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6577206903851176074L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	/** The product. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	/** The quantity. */
	@NonNull
	private int quantity;

	/** The quantity price. */
	@NonNull
	private double quantity_price;

	/** The delivery name. */
	@NonNull
	private String delivery_name;

	/** The delivery address. */
	@NonNull
	private String delivery_address;

	/** The location description. */
	@NonNull
	private String location_description;

	/** The delivery contact. */
	@NonNull
	private String delivery_contact;

	/** The total price. */
	@NonNull
	private double total_price;

	/** The current date. */
	@CreatedDate
	private Date current_date;

	/** The received cash. */
	@NonNull
	private double received_cash;

	/** The balance. */
	@NonNull
	private double balance;

	/**
	 * Instantiates a new order.
	 */
	public OrderDetails() {
		super();
	}

	/**
	 * Instantiates a new order details.
	 *
	 * @param id the id
	 * @param product the product
	 * @param quantity the quantity
	 * @param quantity_price the quantity price
	 * @param delivery_name the delivery name
	 * @param delivery_address the delivery address
	 * @param location_description the location description
	 * @param delivery_contact the delivery contact
	 * @param total_price the total price
	 * @param current_date the current date
	 * @param received_cash the received cash
	 * @param balance the balance
	 */
	public OrderDetails(Long id, Product product, int quantity, double quantity_price, String delivery_name, String delivery_address,
			String location_description, String delivery_contact, double total_price, Date current_date,
			double received_cash, double balance) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.quantity_price = quantity_price;
		this.delivery_name = delivery_name;
		this.delivery_address = delivery_address;
		this.location_description = location_description;
		this.delivery_contact = delivery_contact;
		this.total_price = total_price;
		this.current_date = current_date;
		this.received_cash = received_cash;
		this.balance = balance;
	}

	/**
	 * Instantiates a new order details.
	 *
	 * @param product the product
	 * @param quantity the quantity
	 * @param quantity_price the quantity price
	 * @param delivery_name the delivery name
	 * @param delivery_address the delivery address
	 * @param location_description the location description
	 * @param delivery_contact the delivery contact
	 * @param total_price the total price
	 * @param current_date the current date
	 * @param received_cash the received cash
	 * @param balance the balance
	 */
	public OrderDetails(Product product, int quantity, double quantity_price, String delivery_name, String delivery_address,
			String location_description, String delivery_contact, double total_price, Date current_date,
			double received_cash, double balance) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.quantity_price = quantity_price;
		this.delivery_name = delivery_name;
		this.delivery_address = delivery_address;
		this.location_description = location_description;
		this.delivery_contact = delivery_contact;
		this.total_price = total_price;
		this.current_date = current_date;
		this.received_cash = received_cash;
		this.balance = balance;
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
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Gets the delivery address.
	 *
	 * @return the delivery address
	 */
	public String getDelivery_address() {
		return delivery_address;
	}

	/**
	 * Sets the delivery address.
	 *
	 * @param delivery_address the new delivery address
	 */
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	/**
	 * Gets the location description.
	 *
	 * @return the location description
	 */
	public String getLocation_description() {
		return location_description;
	}

	/**
	 * Sets the location description.
	 *
	 * @param location_description the new location description
	 */
	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}

	/**
	 * Gets the delivery name.
	 *
	 * @return the delivery name
	 */
	public String getDelivery_name() {
		return delivery_name;
	}

	/**
	 * Sets the delivery name.
	 *
	 * @param delivery_name the new delivery name
	 */
	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}

	/**
	 * Gets the delivery contact.
	 *
	 * @return the delivery contact
	 */
	public String getDelivery_contact() {
		return delivery_contact;
	}

	/**
	 * Sets the delivery contact.
	 *
	 * @param delivery_contact the new delivery contact
	 */
	public void setDelivery_contact(String delivery_contact) {
		this.delivery_contact = delivery_contact;
	}

	/**
	 * Gets the total price.
	 *
	 * @return the total price
	 */
	public double getTotal_price() {
		return total_price;
	}

	/**
	 * Sets the total price.
	 *
	 * @param total_price the new total price
	 */
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	/**
	 * Gets the current date.
	 *
	 * @return the current date
	 */
	public Date getCurrent_date() {
		return current_date;
	}

	/**
	 * Sets the current date.
	 *
	 * @param current_date the new current date
	 */
	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}

	/**
	 * Gets the received cash.
	 *
	 * @return the received cash
	 */
	public double getReceived_cash() {
		return received_cash;
	}

	/**
	 * Sets the received cash.
	 *
	 * @param received_cash the new received cash
	 */
	public void setReceived_cash(double received_cash) {
		this.received_cash = received_cash;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
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
	 * Gets the quantity price.
	 *
	 * @return the quantity price
	 */
	public double getQuantity_price() {
		return quantity_price;
	}

	/**
	 * Sets the quantity price.
	 *
	 * @param quantity_price the new quantity price
	 */
	public void setQuantity_price(double quantity_price) {
		this.quantity_price = quantity_price;
	}
}
