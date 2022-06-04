/**
 * 
 */
package jestebancdev.ecommerce.controller;

import java.time.Instant;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jestebancdev.ecommerce.model.Orders;
import jestebancdev.ecommerce.model.Response;
import jestebancdev.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;

/**
 * @author Juan Esteban Castaño Holguin castanoesteban9@gmail.com 2022-06-04
 */

@RestController
@RequiredArgsConstructor
public class OrderController {

	@Autowired
	private OrderService serviceImp;

	@GetMapping(value = "/productbought")
	public ResponseEntity<Response> getOrders() {

		return ResponseEntity
				.ok(Response.builder().timeStamp(Instant.now()).data(Map.of("Orders", serviceImp.getOrderBought()))
						.message("list orders").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());

	}

	@PostMapping(value = "/order")
	public ResponseEntity<Response> createOrder(@RequestBody @Valid Orders orders) {

		return ResponseEntity.ok(
				Response.builder().timeStamp(Instant.now()).data(Map.of("createOrder", serviceImp.createOrder(orders)))
						.message("create Order").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());

	}

	@GetMapping(value = "/product")
	public ResponseEntity<Response> getOrderByProduct(@Param(value = "searchProduct") String nameProduct) {

		return ResponseEntity.ok(Response.builder().timeStamp(Instant.now())
				.data(Map.of("Orders", serviceImp.getOrderByProduct(nameProduct))).message("list orders")
				.status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());

	}

	@GetMapping(value = "/order")
	public ResponseEntity<Response> getOrderByDate(@Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate) {

		return ResponseEntity.ok(Response.builder().timeStamp(Instant.now())
				.data(Map.of("Orders", serviceImp.getOrderByDate(startDate, endDate))).message("list orders")
				.status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());

	}

}
