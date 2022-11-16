package com.example.OrderDetailService.repository;

import java.util.List;

import com.example.OrderDetailService.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	@Query(value = "select * from order_detail where order_id= :orderId", nativeQuery = true)
	public List<OrderDetail> findByOrderId(@Param("orderId") long orderId);
}
