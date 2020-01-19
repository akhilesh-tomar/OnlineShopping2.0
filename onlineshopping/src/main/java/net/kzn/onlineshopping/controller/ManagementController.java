package net.kzn.onlineshopping.controller;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	private static final Logger Logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView ShowManageProducts(@RequestParam(name="operation",required=false)String operation)
	{
		//Logger.info("Hellllllllllllllllllllooooooooooooo");
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nproduct=new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		mv.addObject("product",nproduct);
	//	System.out.println(nproduct.getCategoryId());
		
		if (operation!=null) {
			if (operation.equals("product")) {
			
				mv.addObject("message","product submitted succssfully");
			}
		}
		
		return mv;
		
	}
	
	//handle product submission   . product inside @modelattribute is same as in manageproduct.jsp
	/*
	 * Generally query string is one of client side state management techniques in ASP.NET in which query string 
	 * stores values in URL that are visible to Users. We mostly use query strings to pass data from one page to another 
	 * page in asp.net mvc. In asp.net mvc routing has a support for query strings in RouteConfig.
	 * 
	 */
	
	@RequestMapping(value="/products1234",method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mproduct)
	{			
		
					System.out.println(mproduct.getCategoryId());
			
			
			Logger.info(mproduct.toString());
			productDAO.add(mproduct);
		
		return "redirect:/manage/products?operation=product";
		
	
		
		
		
	}
	
	
	
	//return categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getcategories()
	{
		
		
		return categoryDAO.list();
	}
	
	@RequestMapping(value = "/products123",method=RequestMethod.POST)
	public ModelAndView contact() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","products123");
		mv.addObject("userClickTest",true);
		return mv;				
	}	
	
	
}
