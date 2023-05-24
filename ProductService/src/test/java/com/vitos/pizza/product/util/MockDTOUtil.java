package com.vitos.pizza.product.util;

import com.vitos.pizza.product.entity.Catagory;
import com.vitos.pizza.product.entity.Product;

/**
 * The Class MockDTOUtil.
 */
public class MockDTOUtil {

	/**
	 * Post product.
	 *
	 * @return the product
	 */
	protected Product postProduct() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Cheesy Tomato with Green chillies - Large");
		product.setDescription(
				"A delighful combination of cream cheese & Seeni Sambol topped with Mozzarella & baked to perfection");
		product.setQuantity(1);
		product.setPrice(2660.00);
		product.setCatagory(postCatagory());
		return product;
	}

	/**
	 * Post catagory.
	 *
	 * @return the catagory
	 */
	protected Catagory postCatagory() {
		Catagory catagory = new Catagory();
		catagory.setId(1);
		catagory.setName("Pizza");
		catagory.setDescription("all pizza's allocate this catagory");
		return catagory;

	}

}
