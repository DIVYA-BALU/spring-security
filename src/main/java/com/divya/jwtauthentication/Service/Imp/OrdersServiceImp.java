package com.divya.jwtauthentication.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.divya.jwtauthentication.Model.Orders;
import com.divya.jwtauthentication.Repository.OrderRepository;
import com.divya.jwtauthentication.Service.OrdersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersServiceImp implements OrdersService{

    private final OrderRepository orderRepository;
	@Override
	public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(String id) {
		orderRepository.deleteById(id);
	}

	@Override
	public List<Orders> getAllOrders() {
        return orderRepository.findAll();
	}
    
}
