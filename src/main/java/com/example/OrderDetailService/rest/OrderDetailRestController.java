package com.example.OrderDetailService.rest;

import java.util.List;

import com.example.OrderDetailService.entity.OrderDetail;
import com.example.OrderDetailService.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderDetailRestController {
	@Autowired
	private OrderDetailService orderDetailService;

	@PostMapping("/orderDetail")
	public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail) {
		orderDetailService.save(orderDetail);
		return orderDetail;
	}

	@GetMapping("/orderDetails/byOrderId/{id}")
	public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@PathVariable long id) {
		return ResponseEntity.ok().body(orderDetailService.getOrderDetailsByOrderId(id));
	}

	@PutMapping("/orderDetail")
	public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail
			, @RequestParam("idOrder") long idOrder
			, @RequestParam("idColor") long idColor) {
		orderDetail.setOrderId(idOrder);
		orderDetail.setColorId(idColor);
		orderDetailService.save(orderDetail);
		return orderDetail;
	}

	@DeleteMapping("/orderDetail/{idOrder}")
	public ResponseEntity<String> deleteOrderDetail(@PathVariable long idOrder) {
		List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(idOrder);
		for (OrderDetail od: orderDetails) {
			orderDetailService.delete(od.getId());
		}
		return ResponseEntity.ok().body("Deleted");
	}
}
