package com.example.agency.services;

import com.example.agency.models.Orders;
import com.example.agency.models.enums.Status;
import com.example.agency.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository ordersRepository;

    public List<Orders> findAll() {
        return  ordersRepository.findAll();
    }

    public List<Orders> listOrders(String status) {
        if (status!=null) return ordersRepository.findByStatus(status);
        return ordersRepository.findAll();
    }
    public void saveOrder(Orders orders) {
        log.info("Saving new {}", orders);
        ordersRepository.save(orders);
    }

    public void updateOrderStatus(int id, String status) {
        Optional<Orders> optionalOrder = ordersRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Orders orders = optionalOrder.get();
            orders.setStatus(Status.valueOf(status));
            ordersRepository.save(orders);
        } else {
            throw new IllegalArgumentException("Invalid order ID: " + id);
        }
    }
    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);

    }
}
