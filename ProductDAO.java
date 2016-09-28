package com.niit.ShoppingCart.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ShoppingCart.model.Product;
@Repository
public interface ProductDAO {
	
		public boolean save(Product product);
		
		public boolean update(Product product);
		
		public void delete(int id);
		
		public Product get(int id);
		public List<Product>list();
	}


