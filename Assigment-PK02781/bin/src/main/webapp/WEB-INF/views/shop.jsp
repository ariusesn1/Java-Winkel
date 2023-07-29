<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/include/head.jsp"%>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/include/header.jsp"%>
	<div class="hero-wrap hero-bread"
		style="background-image: url('assets/images/bg_6.jpg');">
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index">Home</a></span> <span>Products</span>
					</p>
					<h1 class="mb-0 bread">Collection Products</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-10 order-md-last">
					<div class="row">
						<c:forEach var="product" items="${Product.content}">
							<div class="col-sm-6 col-md-6 col-lg-4 ftco-animate">
								<div class="product">
									<a href="detail/${product.getId()}" class="img-prod"><img
										class="img-fluid" style="width: 240px; height: 360px"
										src="${product.getImage()}" alt="..."> </a>
									<div class="text py-3 px-3">
										<h3>
											<a href="detail/${product.getId()}">${product.getName() }</a>
										</h3>
										<div class="d-flex">
											<div class="pricing">
												<p class="price">
													<span class="price">${product.getPrice()}$</span>
											</div>
											<div class="rating">
												<p class="text-right">
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
													<a href="#"><span class="ion-ios-star-outline"></span></a>
												</p>
											</div>
										</div>
										<p class="bottom-area d-flex px-3">
											<a href="#" onclick="addToCart(event, ${product.id})"  class="add-to-cart text-center py-2 mr-1"
												> <span>Add
													to Cart <i class="ion-ios-add ml-1"></i>
											</span>
											</a> <a href="#" onclick="addToCart(event, ${product.id})"
												class="buy-now text-center py-2">Buy now<span><i
													class="ion-ios-cart ml-1"></i></span></a>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<ul>
									<li><a href="/shop?p=${Product.number-1}">&lt;</a></li>
									<li>${Product.number}</li>
									<li><a href="/shop?p=${Product.number+1}">&gt;</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 col-lg-2 sidebar">
					<div class="sidebar-box-2">
						<h2 class="heading mb-4">
							<a href="">Search</a>
						</h2>
						<div class="form-group">
							<form class="form-inline" action="/shop" method="post">
								<input placeholder="Search" name="keyword"
									value="${param.keyword}">
								<button style="margin-top: 5px; width: 100%"
									class="btn btn-primary">Search</button>
							</form>
						</div>
					</div>
					<div class="sidebar-box-2">
						<h2 class="heading mb-4">
							<a href="">Category</a>
						</h2>
						<ul>
							<c:forEach var="category" items="${category}">
								<li><a href="${category.id}">${category.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="/include/footer.jsp"%>
	<script>
function addToCart(event, id) {
    event.preventDefault();

    var quantity = 1; // Assuming a default quantity of 1 for now

    // Create a FormData object to send the data to the server
    var formData = new FormData();
    formData.append("Id", id);
    formData.append("quantity", quantity);

    // Send an AJAX request to the server to add the item to the cart
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/cart/add");
    xhr.onload = function() {
        if (xhr.status === 200) {
       	 	alert(" Added item to the cart");
        } else {
            
            alert("Failed to add item to the cart");
        }
    };
    xhr.send(formData);
}
</script>
</body>
</html>