package com.divya.jwtauthentication.Service;

import java.util.List;

import com.divya.jwtauthentication.Model.Orders;

public interface OrdersService {
    Orders saveOrder(Orders order);
    Orders updateOrder(Orders order);
    void deleteOrder(String id);
    List<Orders> getAllOrders();
}
