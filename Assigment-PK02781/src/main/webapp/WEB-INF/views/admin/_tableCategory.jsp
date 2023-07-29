<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@include file="/includeAd/head.jsp"%>
<title>Admin-Category</title>
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
								<h4 class="card-title">Category Management</h4>
								<form:form class="mx-1 mx-md-4" action="/saveCate"
									modelAttribute="category" method="post">
									<div class="form-group">
										<label class="form-label" for="name">ID</label>
										<form:input path="id" class="form-control" type="text"
											id="id" name="id"></form:input>
									</div>
									<div class="form-group">
										<label class="form-label" for="name">Name</label>
										<form:input path="name" class="form-control" type="text"
											id="name" name="name"></form:input>
									</div>
									<div style="margin-top: 15px" class=" flex-fill mb-0">
										<input style="margin-top: 15px" class="btn btn-secondary"
											type="submit" value="Add">
										<button style="margin-top: 15px" class="btn btn-secondary"
											formaction="/updateCate/${category.id}">Update</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="danhsachaccount" style="margin-top: 10px">
		<div class="content-wrapper">
			<div class="container-xxl flex-grow-1 container-p-y">
				<div class="row">
					<div class="col-xl">
						<div class="row">
							<div class="card">
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Name</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0">
											<c:forEach var="danhmuc" items="${Category}">
												<tr>
													<td>${danhmuc.getId() }</td>
													<td>${danhmuc.getName() }</td>
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	href="/deleteCate/${danhmuc.getId() }"><i
																	class="bx bx-trash me-1"></i>Delete</a> <a
																	class="dropdown-item"
																	href="/editCate/${danhmuc.getId() }"><i
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
	</div>

	<%@include file="/includeAd/footer.jsp"%>
</body>
</html>