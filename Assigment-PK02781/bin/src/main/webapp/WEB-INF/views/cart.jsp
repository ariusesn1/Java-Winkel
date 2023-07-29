<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="/include/head.jsp"%>
<title>Cart</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<div class="hero-wrap hero-bread"
		style="background-image: url('assets/images/bg_6.jpg');">
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span>
					</p>
					<h1 class="mb-0 bread">My Cart</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>Product</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="item" items="${cartItems}">
									<form action="/cart/update/${item.product.id }" method="post">
										<input type="hidden" name="id" value="${item.product.id}">
									<tr class="text-center">

										<td class="product-remove">
											<button type="submit"
												formaction="/cart/remove/${item.product.id}"
												class="btn btn-remove">
												<span>Remove</span>
											</button>
										</td>
										<td class="image-prod"><div class="img"
												style="background-image:url(${item.product.image});"></div></td>
										<td class="product-name">
											<h3>${item.product.name}</h3>
											<p>${item.product.description}</p>
										</td>
										<td class="price">${item.product.price}$</td>
										<td class="quantity">
											<div class="input-group mb-3">

												<input name="quantity" value="${item.quantity}"
													onblur="this.form.submit()"
													class="quantity form-control input-number" value="1"
													min="1" max="100">

											</div>
										</td>
										<td class="total">${item.product.price * item.quantity} $</td>
									</tr>
									</form>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col col-lg-5 col-md-6 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>Cart Totals</h3>
						<p class="d-flex">
							<span>Subtotal</span> $<span id="subtotal"></span>
						</p>
						<p class="d-flex">
							<span>Delivery</span> $<span id="delivery"></span>
						</p>
						<hr>
						<p class="d-flex">
							<span>Total</span> $<span id="total"></span>
						</p>
					</div>
					<p class="text-center">
					<form action="/cart/checkout" method="post">
						<button type="submit"  class="btn btn-primary py-3 px-4">Proceed
							to Checkout</button>
						</form>
					</p>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/include/footer.jsp"%>
<script>
  // Calculate and update the cart totals
  function updateCartTotals() {
    var cartItems = document.querySelectorAll('.cart-list tbody tr');
    var subtotal = 0;

    cartItems.forEach(function(item) {
      var priceElement = item.querySelector('.price');
      var quantityElement = item.querySelector('.quantity input');
      var totalElement = item.querySelector('.total');

      var price = parseFloat(priceElement.textContent);
      var quantity = parseInt(quantityElement.value);
      var total = price * quantity;

      totalElement.textContent = total.toFixed(2);
      subtotal += total;
    });

    var subtotalElement = document.getElementById('subtotal');
    var deliveryElement = document.getElementById('delivery');
    var totalElement = document.getElementById('total');

    subtotalElement.textContent = subtotal.toFixed(2);

    if (cartItems.length > 0) {
      // Generate a random delivery value between 10 and 15
      var delivery = (Math.random() * 5) + 10;
      deliveryElement.textContent = delivery.toFixed(2);

      var total = subtotal + delivery;
      totalElement.textContent = total.toFixed(2);
    } else {
      deliveryElement.textContent = '0.00';
      totalElement.textContent = subtotal.toFixed(2);
    }
  }

  // Call the updateCartTotals function when the page is loaded
  window.addEventListener('load', updateCartTotals);
  </script>
</body>
</html>
