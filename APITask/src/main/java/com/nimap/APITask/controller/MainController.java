package com.nimap.APITask.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.APITask.entity.Categories;
import com.nimap.APITask.entity.Products;
import com.nimap.APITask.service.MainService;


@RestController
@RequestMapping("/api")
public class MainController {
    
	@Autowired
	MainService service;
	
	@PostMapping("/categories")
	public String addcategories(@RequestBody Categories c) {
	String msg=	service.addcategories(c);
	return msg;
	}
	
	@GetMapping("/getAllCategories")
	public List<Categories> getAllcategories(@RequestParam int page){
		
		List<Categories> list= service.getAllcategories(page);
		
		return list;
		
	}
	
	@DeleteMapping("/deletecategories/{id}")
	public String deleteCategories(@PathVariable int id) {
		
		String msg= service.deleteCategories(id);
		return msg;
		
	}
	
	@GetMapping("/getparticularEmp/{id}")
	public Categories getParticularEmployeeById(@PathVariable int id) {
		
		Categories c= service.getParticularEmpByID(id);
		return c;
		
	}
	
	@PutMapping("/updateEmp")
	public String updateCategories(@RequestBody Categories c) {
		
		String msg= service.updateCategories(c);
		
		return msg;
		
	}
	
	
	//products
	
	
	
	@PostMapping("/products")
	public String addproducts(@RequestBody Products c) {
	String msg=	service.addProduts(c);
	return msg;
	}
	
	
	@GetMapping("/getAllProducts")
	public List<Products> getAllproducts(@RequestParam int page){
		
		List<Products> list= service.getAllproducts(page);
		
		return list;
		
	}
	
	@DeleteMapping("/deleteproducts/{id}")
	public String deleteProducts(@PathVariable int id) {
		
		String msg= service.deleteProducts(id);
		return msg;
		
	}
	
	@GetMapping("/getparticularProducts/{id}")
	public Products getParticularProductsById(@PathVariable int id) {
		
		Products c= service.getParticularProductsByID(id);
		return c;
		
	}
	
	
	@PutMapping("/updateProducts")
	public String updateProducts(@RequestBody Products c) {
		
		String msg= service.updateProducts(c);
		
		return msg;
		
	}

	
	
}
