<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%@include file="/includeAd/head.jsp"%>
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
								<h4 class="card-title">Account Management</h4>
								<form:form class="mx-1 mx-md-4" action="/saveAcc"
									modelAttribute="account" method="post">
									<div class="form-group">
										<label class="form-label" for="Username">Username</label>
										<form:input path="username" class="form-control" type="text"
											id="Username" />
									</div>
									<div class="form-group">
										<label class="form-label" for="Password">Password</label>
										<form:input path="password" class="form-control"
											type="password" id="Password" />
									</div>
									<div class="form-group">
										<label class="form-label" for="Email">Email</label>
										<form:input path="email" class="form-control" type="email"
											id="Email" />
									</div>
									<div class="form-group" style="margin-top: 5px">
										<label class="form-label" for="Admin">Authorization : </label>
										
											<form:radiobuttons path="admin"  cssStyle="margin-left : 7px"
												items="${Admin}"/>
									</div>
									<div class="form-group">
										<input style="margin-top: 5px" class="btn btn-secondary"
											type="submit" value="Add" />
										<button style="margin-top: 5px" class="btn btn-secondary"
											formaction="/updateAcc/${account.username}">Update</button>
									</div>
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
							<div class="table-responsive">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Username</th>
											<th>Password</th>
											<th>Email</th>
											<th>Authorization</th>
										</tr>
									</thead>
									<tbody class="table-border-bottom-0">
										<c:forEach var="accountList" items="${accountList}">
											<tr>
												<td>${accountList.getUsername() }</td>
												<td>${accountList.getPassword() }</td>
												<td>${accountList.getEmail() }</td>
												<td>${accountList.getAdmin() }</td>
												<td>
													<div class="dropdown">
														<button type="button"
															class="btn p-0 dropdown-toggle hide-arrow"
															data-bs-toggle="dropdown">
															<i class="bx bx-dots-vertical-rounded"></i>
														</button>
														<div class="dropdown-menu">
															<a class="dropdown-item"
																href="/deleteAcc/${accountList.getUsername() }"><i
																class="bx bx-trash me-1"></i>Delete</a> <a
																class="dropdown-item"
																href="/editAcc/${accountList.getUsername() }"><i
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
</body>
</html>