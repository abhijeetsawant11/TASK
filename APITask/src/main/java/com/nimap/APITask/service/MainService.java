package com.nimap.APITask.service;

import java.util.List;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.APITask.dao.MainDao;
import com.nimap.APITask.entity.Categories;
import com.nimap.APITask.entity.Products;


@Service
public class MainService {
    @Autowired
	MainDao dao;
	
	public String addcategories(Categories c) {
		String msg= dao.addcategories(c);
		
		if(Objects.isNull(msg)) {
			msg="Data is not added succesfully...";
		}
		return msg;
	}
	

	public List<Categories> getAllcategories(int page) {
		List<Categories> list=dao.getAllcategories(page);
		return list;
	}


	public String deleteCategories(int id) {
		String msg=dao.deletecategories(id);
		if(Objects.isNull(msg)) {
			msg="Data is not added succesfully...";
		}
		return msg;

	}


	public Categories getParticularEmpByID(int id) {
		Categories c=dao.getCategoriesById(id);
		if(Objects.isNull(c))	{
			c=null;
		}
		return c;
	
	}


	public String updateCategories(Categories c) {
		String msg= dao.updateCategories(c);
		
		if(Objects.isNull(msg)) {
			msg="Record Is not be updatated";
		}
	
	return msg;
}


	public String addProduts(Products c) {
		
        String msg= dao.addproduts(c);
		
		if(Objects.isNull(msg)) {
			msg="Data is not added succesfully...";
		}
		return msg;
	}


	public List<Products> getAllproducts(int page) {
		
		List<Products> list=dao.getAllproducts(page);
		return list;
		
	}


	public String deleteProducts(int id) {
		
		String msg=dao.deleteproducts(id);
		if(Objects.isNull(msg)) {
			msg="Data is not added succesfully...";
		}
		return msg;
			}


	public Products getParticularProductsByID(int id) {
		Products c=dao.getProductsById(id);
		if(Objects.isNull(c))	{
			c=null;
		}
		return c;
		
		
	}


	public String updateProducts(Products c) {
          String msg= dao.updateProducts(c);
		
		if(Objects.isNull(msg)) {
			msg="Record Is not be updatated";
		}
	
	return msg;
		
	}




	
}
