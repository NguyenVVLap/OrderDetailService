package com.example.OrderDetailService.service;

import java.util.List;

import com.example.OrderDetailService.entity.OrderDetail;

public interface OrderDetailService {
	public List<OrderDetail> getOrderDetailsByOrderId(long theId);
	public void save(OrderDetail theOrderDetails);
	public void delete(long id);
}
