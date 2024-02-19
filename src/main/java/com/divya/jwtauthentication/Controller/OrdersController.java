package com.divya.jwtauthentication.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.jwtauthentication.Model.Orders;
import com.divya.jwtauthentication.Service.OrdersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;
    
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('order_post')")
    public ResponseEntity<Orders> saveOrder(Orders order) {
        return ResponseEntity.ok(ordersService.saveOrder(order));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('order_put')")
    public ResponseEntity<Orders> updateOrder(Orders order) {
        return ResponseEntity.ok(ordersService.updateOrder(order));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('order_delete')")
    public ResponseEntity<String> deleteOrder(String id) {
        ordersService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully");
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('order_get')")
    public ResponseEntity<List<Orders>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

}
