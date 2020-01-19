package net.kzn.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView ShowManageProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nproduct=new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		mv.addObject("product",nproduct);
		return mv;
		
	}
	
	//return categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getcategories()
	{
		
		return categoryDAO.list();
	}
}
