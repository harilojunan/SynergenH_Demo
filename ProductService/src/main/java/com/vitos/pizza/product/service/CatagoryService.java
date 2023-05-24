package com.vitos.pizza.product.service;

import java.util.List;

import com.vitos.pizza.product.entity.Catagory;
import com.vitos.pizza.product.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.product.exception.ResourceNotFoundException;

/**
 * The Interface CatagoryService.
 */
public interface CatagoryService {
	
	/**
	 * SaveCatagory.
	 *
	 * @param catagory the catagory
	 * @return the catagory
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public Catagory saveCatagory(Catagory catagory) throws ResourceAlreadyFoundException;
	
	/**
	 * Gets the all catagorys.
	 *
	 * @return the all catagorys
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public List<Catagory> getAllCatagorys() throws ResourceNotFoundException;
	
	/**
	 * Gets the catagory by id.
	 *
	 * @param id the id
	 * @return the catagory by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Catagory getCatagoryById(Long id) throws ResourceNotFoundException;
	
	/**
	 * Delete catagory.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteCatagory(Long id) throws ResourceNotFoundException;

}
