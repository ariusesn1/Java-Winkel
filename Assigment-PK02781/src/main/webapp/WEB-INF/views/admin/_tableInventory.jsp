<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="/includeAd/head.jsp"%>
<title>Inventory</title>
</head>
<body>
	<%@ include file="/includeAd/headerAd.jsp"%>
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
												<th>Category</th>
												<th>Total</th>
												<th>Count</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0">
											<c:forEach var="item" items="${list}">
												<tr>
													<td>${item.group.name}</td>
													<td>${item.sum}</td>
													<td>${item.count}</td>
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
	<%@ include file="/includeAd/footer.jsp"%>
</body>
</html>