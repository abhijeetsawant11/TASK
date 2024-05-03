package com.nimap.APITask.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nimap.APITask.entity.Categories;
import com.nimap.APITask.entity.Products;


@Repository
public class MainDao {

	private static final int O = 0;
	@Autowired
	SessionFactory factory;
	
	public String addcategories(Categories c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 
		 session.persist(c);
		 tx.commit();
		 msg="Data Addedd Succefully..";
		 
		}catch (Exception e) {	
			//TODO: handle exeption
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
			
}

	public List<Categories> getAllcategories(int page) {
		Session session=null;
		Transaction tx=null;
		String strQuery="from Categories";
		List<Categories> list=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 
			 int startingindex=page*O;
			 list=session.createQuery(strQuery,Categories.class).setFirstResult(startingindex).setMaxResults(page).list();
			 
//			 Query<Categories> query= session.createQuery(strQuery,Categories.class);
//			 
//			 list=query.list();
			 tx.commit();
			 
			 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public String deletecategories(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 Categories categories= session.get(Categories.class, id);
		
		 session.remove(categories);
		 tx.commit();
		 
		 msg="Record is Deleted";
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public Categories getCategoriesById(int id) {
		Session session=null;
		Transaction tx=null;
		Categories categories=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		  categories= session.get(Categories.class, id);
		 tx.commit();		 
		
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		 
		 
	return categories;

	}

	public String updateCategories(Categories c) {
	
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 Categories categories= session.get(Categories.class, c.getCid());
		 
		 categories.setCname(c.getCname());
		    session.merge(categories);	
		 
		 
		 tx.commit();
		 msg="Record is updatated";
		 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;	
		
	
	}

	public String addproduts(Products c) {
	
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 
		 
		 session.persist(c);
		 tx.commit();
		 msg="Data Addedd Succefully..";
		 
		}catch (Exception e) {	
			//TODO: handle exeption
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Products> getAllproducts(int page) {
		
		Session session=null;
		Transaction tx=null;
		String strQuery="from Products";
		List<Products> list=null;
		try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 
			 int startingindex=page*O;
			 list=session.createQuery(strQuery,Products.class).setFirstResult(startingindex).setMaxResults(page).list();
			 
//			 Query<Categories> query= session.createQuery(strQuery,Categories.class);
//			 
//			 list=query.list();
			 tx.commit();
			 
			 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}

	public String deleteproducts(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 Products products= session.get(Products.class, id);
		
		 session.remove(products);
		 tx.commit();
		 
		 msg="Record is Deleted";
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
		
	}

	public Products getProductsById(int id) {
		
		
		Session session=null;
		Transaction tx=null;
		Products products=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		  products= session.get(Products.class, id);
		 tx.commit();		 
		
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		 
		 
	return products;

		
		
	}
 @SuppressWarnings({"deprecation","unused"})
 
	public String updateProducts(Products p) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 Products products= session.get(Products.class, p.getId());
		 
		 products.setName(p.getName());
		 products.setSize(p.getSize());
		 products.setColor(p.getColor());
		 products.setCategories(p.getCategories());
		 session.update(products);
		 session.beginTransaction().commit();

		 msg="record is updated.....";
		 
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;	
		
		
		
	}

	
	
}