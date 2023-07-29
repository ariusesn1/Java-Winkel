<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin-Product</title>
<%@include file="/includeAd/head.jsp"%>
<style>
.error {
	color: red;
}
</style>
<script
	src="https://cdn.ckeditor.com/ckeditor5/37.1.0/classic/ckeditor.js"></script>
</head>
<body>
	<%@include file="/includeAd/headerAd.jsp"%>
	<div class="content-wrapper">
		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="row">
				<div class="col-xl">
					<div class="row">
						<div class="card" style="margin-top: 25px">
							<div class="card-body">
								<h4 class="card-title">Product Management</h4>
								<form:form name="add" action="/saveProd"
									modelAttribute="product" enctype="multipart/form-data"
									onsubmit="return validateForm()">
									<div class="form-group">
										<label class="form-label" for="id">ID</label>
										<form:input path="id" class="form-control" type="text" id="id"
											name="id" />
										<form:errors path="id" cssClass="error"></form:errors>
									</div>
									<div class="form-group">
										<label class="form-label" for="name">Name</label>
										<form:input path="name" class="form-control" type="text"
											id="name" name="name" />
										<form:errors path="name" cssClass="error"></form:errors>
									</div>
									<div class="form-group">
										<label class="form-label" for="price">Price</label>
										<form:input path="price" class="form-control" type="text"
											id="price" name="price" />
										<form:errors path="price" cssClass="error"></form:errors>
									</div>
									<div class="form-group">
										<label class="form-label" for="file">Image</label> <input
											class="form-control" type="file" id="file" name="file" />
									</div>
									<div class="form-group">
										<label class="form-label" for="category">Category</label>
										<form:select path="category.id" class="form-control"
											id="category">
											<form:option value="">-- Select Category --</form:option>
											<c:forEach var="category" items="${category}">
												<form:option value="${category.id}">${category.name}</form:option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<label class="form-label" for="price">Description</label>
										<form:textarea path="description" class="form-control"
											type="text" id="description" name="description" />
										<form:errors path="description" cssClass="error"></form:errors>
									</div>
									<button style="margin-top: 15px" class="btn btn-secondary">Create</button>
									<button style="margin-top: 15px" class="btn btn-secondary"
										formaction="/updateProd/${product.id}">Update</button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="content-wrapper">
		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="row">
				<div class="col-xl">
					<div class="row">
						<div class="card">
							<div class="table-responsive text-nowrap">
						<form style="margin-top:7px" action="/price" method="post">
							<input style="margin-top:5px" class="form-control" placeholder="Min" value="${param.min}" name="min"> 
							<input style="margin-top:5px" class="form-control" placeholder="Max" value="${param.max}" name="max">
							<button style="margin-top:7px" class="btn btn-secondary" >Search</button>
						</form>
								<table class="table table-hover">
									<thead>
										<tr class="text-nowrap">
											<td><a href="/product/sort?field=id" >ID</a></td>
											<td>Name</td>
											<td><a href="/product/sort?field=price" >Price</a></td>
											<td>Description</td>
											<td>Image</td>
											<td>Category</td>
										</tr>
									</thead>
									<tbody class="table-border-bottom-0">
										<c:forEach var="product" items="${Product}">
											<tr>
												<td>${product.getId() }</td>
												<td>${product.getName() }</td>
												<td>${product.getPrice()}</td>
												<td>${product.getDescription() }</td>
												<td><img style="width: 80px; height: 60px"
													src="${product.getImage()}" alt="..."></td>
												<td>${product.getCategory().getName()}</td>
												<td>
													<div class="dropdown">
														<button type="button"
															class="btn p-0 dropdown-toggle hide-arrow"
															data-bs-toggle="dropdown">
															<i class="bx bx-dots-vertical-rounded"></i>
														</button>
														<div class="dropdown-menu">
															<a class="dropdown-item" href="/deleteProd/${product.id}"><i
																class="bx bx-trash me-1"></i>Delete</a> <a
																class="dropdown-item"
																href="/editProd/${product.getId() }"><i
																class="bx bx-edit-alt me-1"></i>Edit</a>
														</div>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/includeAd/footer.jsp"%>
	<script>
    ClassicEditor
        .create( document.querySelector( '#description' ) )
        .catch( error => {
            console.error( error );
        } );
</script>
</body>
</html>
