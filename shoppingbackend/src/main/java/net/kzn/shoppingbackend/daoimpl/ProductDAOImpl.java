package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub

		try {
			sessionfactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		// Integer.valueOf(id)-->In method primitive type is mentioned and below we give
		// ref so for compatibility we are usin it
		return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(Product product) {
		// tryTODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		product.setActive(false);
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectActiveProducts = "FROM Product WHERE active= :active";
		return sessionfactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();

	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryID) {
		// TODO Auto-generated method stub
		String selectActiveProductsByCategory = "FROM Product where active= :active AND categoryId= :categoryID";
		return sessionfactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryID", categoryID).getResultList();

	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		// TODO Auto-generated method stub
		
		String selectLatestActiveProductsByCategory = "FROM Product where active= :active ORDER BY id";
		return sessionfactory.getCurrentSession().createQuery(selectLatestActiveProductsByCategory, Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();

		
	}

}
