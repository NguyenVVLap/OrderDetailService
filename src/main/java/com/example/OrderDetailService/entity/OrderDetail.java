package com.example.OrderDetailService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "order_id")
	private long orderId;

	@Column(name = "color_id")
	private long  colorId;
	
	private int quantity;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	private double price;
}
