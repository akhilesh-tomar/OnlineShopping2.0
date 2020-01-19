$(function() {
	// solving the active menu problem
	switch(menu) {
	
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
		default:	
			if(menu == "Home") break;
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;		
	}
	
	
	// code for jquery dataTable

	
	var $table = $('#productListTable');
	
	// execute the below code only where we have this table
	if($table.length) {
		console.log('Inside the table!');
		
		var jsonUrl ='';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot +'/json/data/all/products';
			console.log("Hello"+window.contextRoot);
		}
		else {
			jsonUrl = window.contextRoot +'/json/data/category/'+ window.categoryId +'/products';
		}
			
		
		
		$table.DataTable( {
			
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc:''
			},
			columns: [
				
				 {
		        	  data: 'code',
		        	  mRender: function(data,type,row)
		        	  {
		        		
		        		  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
		        	  }
		          },
			 
			          {
			        	  data: 'name'			        	  
			          },
			          {
			        	  data: 'brand'			        	  
			          },
			          {
			        	  data: 'unitPrice',
			        	  mRender: function(data,type,row)
			        	  {
			        		  return '&#8377;'+data
			        	  }
			          },
			          {
			        	  data: 'quantity'			        	  
			          },
			          
			          {
			        	  data: 'id',
			        	  mRender: function(data,type,row)
			        	  {
			        		  bSortable=false;
			        		  var str='';
			        		  
			        		//  Adding symbol for view icon
			        		  str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>View</a> &#70';
			        		  
			        		 //Addin symbol for cart icon 
			        		  str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> Add to cart</a>';
			        		  return str;
			        	  }
			          }
			         
			          ]
		});
	}
	
	var $alert=$('.alert');
	if($alert.length)
		{
		setTimeout(function()
				{
			$alert.fadeOut('slow');
				},3000)
		}
});