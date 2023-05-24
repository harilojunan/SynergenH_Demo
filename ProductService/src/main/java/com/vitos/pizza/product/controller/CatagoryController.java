package com.vitos.pizza.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitos.pizza.product.entity.Catagory;
import com.vitos.pizza.product.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.product.exception.ResourceNotFoundException;
import com.vitos.pizza.product.service.CatagoryService;
import com.vitos.pizza.product.util.AppConstants;

/**
 * The Class CatagoryController.
 */
@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class CatagoryController {
	
	/** The catagory service. */
	@Autowired
	private CatagoryService catagoryService;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CatagoryController.class);
	
	/**
	 * Save catagory.
	 *
	 * @param catagory the catagory
	 * @return the response entity
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@PostMapping(AppConstants.CATAGORY_URL)
	public ResponseEntity<Catagory> saveCatagory(@RequestBody Catagory catagory) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Catagory Controller @Save Catagory Method Initiated");
		Catagory savedCatagory = catagoryService.saveCatagory(catagory);

		if (null != savedCatagory) {
			return new ResponseEntity<Catagory>(savedCatagory, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Gets the all catagorys.
	 *
	 * @return the all catagorys
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.CATAGORYS_URL)
	public ResponseEntity<List<Catagory>> getAllCatagorys() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Catagory Controller @Get All Catagory Method Initiated");
		return new ResponseEntity<>(catagoryService.getAllCatagorys().stream().collect(Collectors.toList()),
				HttpStatus.OK);
	}
	
	/**
	 * Gets the catagory by id.
	 *
	 * @param id the id
	 * @return the catagory by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.CATAGORY_BY_ID_URL)
	public ResponseEntity<Catagory> getCatagoryById(@PathVariable Long id) throws ResourceNotFoundException {
		logger.info("Loggig Stated!!! Inside Catagory Controller logger.info @Get Catagory By ID Method Initiated");
		Catagory catagoryRetrieved = catagoryService.getCatagoryById(id);
		return new ResponseEntity<Catagory>(catagoryRetrieved, HttpStatus.OK);
	}
	
	/**
	 * Delete catagory by id.
	 *
	 * @param id the id
	 * @return the http status
	 */
	@DeleteMapping(AppConstants.CATAGORY_BY_ID_URL)
	public HttpStatus deleteCatagoryById(@PathVariable("id") Long id) {
		logger.info("Logging Stated!!! Inside Catagory Controller @Delete Catagory Method Initiated");
		try {
			catagoryService.deleteCatagory(id);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return HttpStatus.OK;
	}

}
