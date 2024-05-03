package com.nimap.APITask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Products {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
  private String name;
   private String size;
   private String color;

   @ManyToOne
   @JoinColumn(name="cid")
   private Categories categories;
   
   
   
   public Products()
   {
	   
   }



public Products (String name, String size, String color, Categories categories) {
	super();
	this.name = name;
	this.size = size;
	this.color = color;
	this.categories = categories;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getSize() {
	return size;
}



public void setSize(String size) {
	this.size = size;
}



public String getColor() {
	return color;
}



public void setColor(String color) {
	this.color = color;
}



public Categories getCategories() {
	return categories;
}



public void setCategories(Categories categories) {
	this.categories = categories;
}



@Override
public String toString() {
	return "Products [id=" + id + ", name=" + name + ", size=" + size + ", color=" + color + ", categories="
			+ categories + "]";
}
}
