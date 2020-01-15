package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	
	boolean add(Category category);
	Category get(int id);
	boolean update(Category category);
	boolean delete(Category category);
	
}

