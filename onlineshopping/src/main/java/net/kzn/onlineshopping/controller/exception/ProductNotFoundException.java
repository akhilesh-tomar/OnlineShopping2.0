package net.kzn.onlineshopping.controller.exception;

public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ProductNotFoundException()
	{
		//this constructor will call string argument construct
		this("product is not available");
	}

	public ProductNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		this.message=System.currentTimeMillis()+":"+message;
	}
	
	public String getMessage()
	{
		return message;
	}
	

}
