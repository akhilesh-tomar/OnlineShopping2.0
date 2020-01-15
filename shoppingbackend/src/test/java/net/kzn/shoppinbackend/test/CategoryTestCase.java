package net.kzn.shoppinbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Mobile123");
	 * category.setDescription("This is some description for laptop!");
	 * category.setImageURL("CAT_108.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!",true,
	 * categoryDAO.add(category));
	 * 
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testGetCategory1() {
	 * 
	 * category = new Category();
	 * 
	 * category = categoryDAO.get(33);
	 * 
	 * assertEquals("Successfully Fetched a category from the table!", "Laptop",
	 * category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category = categoryDAO.get(33); category.setName("Mobile");
	 * 
	 * assertEquals("Successfully update a category from the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category = categoryDAO.get(33);
	 * 
	 * 
	 * assertEquals("Successfully update a category from the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * 
	 * assertEquals("Successfully update a category from the table!", 2,
	 * categoryDAO.list().size());
	 * 
	 * }
	 * 
	 */

	@Test
	public void testCRUD() {

		// Adding the category
		category = new Category();

		category.setName("Mobile");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_101.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for Television!");
		category.setImageURL("CAT_102.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_103.png");
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

	//	Fetch the category based on ID

		category = new Category();

		category = categoryDAO.get(1);
		assertEquals("Successfully Fetched a category from the table!", "Mobile", category.getName());

		// Updating the cateory
				category = new Category();

				category = categoryDAO.get(1);
				category.setName("Cell-phone");
				assertEquals("Successfully update a category from the table!", true, categoryDAO.update(category));
			
				// delete/deactivated the category
				category = new Category();
				category = categoryDAO.get(1);
				assertEquals("Successfully deactivated a category from the table!", true, categoryDAO.delete(category));

				// fetching the list of category
				assertEquals("Successfully Fetched active category from the table!", 2, categoryDAO.list().size());
	}

}
