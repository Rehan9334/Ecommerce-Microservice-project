package nit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import nit.entity.Order;
import nit.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService service;
	
	@PostMapping
	public Order create(@RequestBody Order order) {
		return service.placeOrder(order);
	}
	
	@GetMapping
	public List<Order> getAllOrders(){
		return service.getAllOrders();
	}
}
