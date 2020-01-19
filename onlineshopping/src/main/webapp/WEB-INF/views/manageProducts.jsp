<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>>

<!--We need to modify the form to link it with the product model which is sending through or management controller  

Whenever we are using the same form for edit purpose some field should not reset to default values those values need to be stored in hidden
fields. i.e
set the other fileds as hidden otherwise it will return the default values instead of original values when we would be using the same form to 
edit the product

-->
<div class="container">

	<c:if test="${not empty message}">
			<div class="row">
				<div class="col-xs-12 col-md-offset-2 col-md-8">
				
					<div class="alert alert-info fade in">${message}</div>
				</div>
			</div>
		</c:if>

	<div class="row">
		



		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary ">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">

					<!--Form Elements  -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products1234" method="POST">
						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Product name</label>
							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="product Name" class="form-control" />
								<em class="help-block">Please enter product Name</em>

							</div>
						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Enter brand Name" class="form-control" />
								<em class="help-block">Please enter product Name</em>

							</div>
						</div>




						<div class="form-group">

							<label class="control-label col-md-4" for="descriptio">Product
								Description</label>
							<div class="col-md-8">

								<sf:textarea path="description" id="description"
									placeholder="Enter description" row="4" class="form-control" />




							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit price</label>
							<div class="col-md-8">

								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Unit price in &#8377" class="form-control" />
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="quantity">Quantity
								Available </label>
							<div class="col-md-8">

								<sf:input type="text" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="categoryId">Select
								Category </label>
							<div class="col-md-8">
								<!--categories is mentioned in model attribute  -->
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<!-- 
									path is mapped to id . while submission item value is submitted to server in which that id only passed
								
									<option value="1">Category One</option>
									<option value="2">Category Two</option>
									
									- -->

							</div>
						</div>

						<div class="form-group">


							<div class="col-md-offset-4 col-md-8 ">

								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>







					</sf:form>
				</div>

			</div>



		</div>


	</div>

</div>

