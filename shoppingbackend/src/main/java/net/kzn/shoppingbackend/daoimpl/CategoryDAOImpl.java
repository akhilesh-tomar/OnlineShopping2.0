package net.kzn.shoppingbackend.daoimpl;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
//	private static List<Category> categories = new ArrayList<>();
	
/*	
	static {
		
		Category category = new Category();
		
		 adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_1.png");
		
		//categories.add(category);
		
		second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for mobile!");
		category.setImageURL("CAT_2.png");
		
		
		
	//	categories.add(category);
		
	
		//third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
		
		
	}
	
	*/
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		String slectActiveCategory="FROM Category WHERE active= :active";
		
		Query query=sessionFactory.getCurrentSession().createQuery(slectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}


/*
	@Override
	public Category get(int id) {
		
		// enhanced for loop
		for(Category category : categories) {
			
			if(category.getId() == id) return category;
			
		}
		
		
		return null;
		
		
	}
*/


	@Override
	public boolean add(Category category) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	
	}

	//etting a single category
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}


	@Override
	public boolean update(Category category) {
		try {
			// update  the category to the database table
			sessionFactory.getCurrentSession().update(category);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	
	}

	/*
	 * here we are not deleting any item we are just setting value as false to the required item
	 * and use update method .If it return true means value is updated as false. item will remain in database
	 * but it'svalue become false i.e not active anymore
	 */
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			// update  the category to the database table
			sessionFactory.getCurrentSession().update(category);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	
	}
	

}
