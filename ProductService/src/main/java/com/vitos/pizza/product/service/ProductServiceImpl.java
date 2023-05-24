package com.vitos.pizza.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitos.pizza.product.entity.Product;
import com.vitos.pizza.product.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.product.exception.ResourceNotFoundException;
import com.vitos.pizza.product.repo.ProductRepo;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The product repo. */
	@Autowired
	private ProductRepo productRepo;
	
	/**
	 * Instantiates a new product service impl.
	 *
	 * @param productRepo the product repo
	 */
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the product
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@Override
	public Product saveProduct(Product product) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Product Service @Save Product Method Running");
		if (productRepo.existsById(product.getId())) {
			throw new ResourceAlreadyFoundException("Product already found");
		}
		Product savedProduct = productRepo.save(product);
		return savedProduct;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public List<Product> getAllProducts() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Product Service @Get All Products Method Running");
		return productRepo.findAll();
	}

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public Product getProductById(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Products Service @Find By ID Product Method Started");
		if (productRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Product not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Product Service @Get Product Method Started");
			Product product = productRepo.findById(id).get();
			return product;
		}
	}

	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public String deleteProduct(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Products Service @Find By ID Product Method Started");
		if (productRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Product not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Product Service @Delete Product Method Started");
			productRepo.deleteById(id);
		}
		return "Product Deleted Successfully with id : "+id;
	}

}
