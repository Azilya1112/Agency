package com.example.agency.controllers;


import com.example.agency.models.enums.Status;
import com.example.agency.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @GetMapping("")
    public String orders(@RequestParam(name="name", required = false) String status, Model model) {
        model.addAttribute("orders", orderService.listOrders(status));
        return "listOfOrders";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "listOfOrders";
    }


    @PostMapping("/{id}/setStatus")
    public String setStatus(@PathVariable int id, @RequestParam Status status) {
//        Orders orders = orderService.getOrderById(id);
//        orders.setStatus(status);
        orderService.updateOrderStatus(id, String.valueOf(status));
        return "redirect:/orders/getAll"; // перенаправляем на страницу просмотра заказа
    }

//    @PostMapping("/setStatus")
//    public String setStatus(@RequestParam("orderId") int orderId, @RequestParam("status") String status) {
//        orderService.updateOrderStatus(orderId, status);
//        return "redirect:/orders"; // Перенаправление на страницу списка заказов после изменения статуса
//    }
}
