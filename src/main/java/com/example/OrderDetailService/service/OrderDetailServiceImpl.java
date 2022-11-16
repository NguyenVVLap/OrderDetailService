package com.example.OrderDetailService.service;

import java.util.ArrayList;
import java.util.List;

import com.example.OrderDetailService.entity.OrderDetail;
import com.example.OrderDetailService.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public List<OrderDetail> getOrderDetailsByOrderId(long theId) {
		return orderDetailRepository.findByOrderId(theId);
	}

	@Override
	public void save(OrderDetail theOrderDetails) {
		orderDetailRepository.save(theOrderDetails);
	}

	@Override
	public void delete(long id) {
		orderDetailRepository.deleteById(id);
	}

	
}
