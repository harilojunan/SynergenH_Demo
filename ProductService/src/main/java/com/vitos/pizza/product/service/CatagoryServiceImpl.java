package com.vitos.pizza.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitos.pizza.product.entity.Catagory;
import com.vitos.pizza.product.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.product.exception.ResourceNotFoundException;
import com.vitos.pizza.product.repo.CatagoryRepo;

/**
 * The Class CatagoryServiceImpl.
 */
@Service
public class CatagoryServiceImpl implements CatagoryService {
	
	/** The catagory repo. */
	@Autowired
	private CatagoryRepo catagoryRepo;
	
	/**
	 * Instantiates a new catagory service impl.
	 *
	 * @param catagoryRepo the catagory repo
	 */
	public CatagoryServiceImpl(CatagoryRepo catagoryRepo) {
		this.catagoryRepo = catagoryRepo;
	}
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	/**
	 * Save catagory.
	 *
	 * @param catagory the catagory
	 * @return the catagory
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@Override
	public Catagory saveCatagory(Catagory catagory) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Catagory Service @Save Catagory Method Running");
		if (catagoryRepo.existsById(catagory.getId())) {
			throw new ResourceAlreadyFoundException("Product already found");
		}
		Catagory savedCatagory = catagoryRepo.save(catagory);
		return savedCatagory;
	}

	/**
	 * Gets the all catagorys.
	 *
	 * @return the all catagorys
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public List<Catagory> getAllCatagorys() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Catagory Service @Get All Catagorys Method Running");
		return catagoryRepo.findAll();
	}

	/**
	 * Gets the catagory by id.
	 *
	 * @param id the id
	 * @return the catagory by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public Catagory getCatagoryById(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Catagory Service @Find By ID Catagory Method Started");
		if (catagoryRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Catagory not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Catagory Service @Get Catagory Method Started");
			Catagory catagoryRequest = catagoryRepo.findById(id).get();
			return catagoryRequest;
		}
	}

	/**
	 * Delete catagory.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public String deleteCatagory(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Catagory Service @Find By ID Catagory Method Started");
		if (catagoryRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Catagory not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Catagory Service @Delete Catagory Method Started");
			catagoryRepo.deleteById(id);
		}
		return "Catagory Deleted Successfully with id : "+id;
	}

}
