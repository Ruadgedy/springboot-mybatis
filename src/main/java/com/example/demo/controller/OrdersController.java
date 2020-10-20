package com.example.demo.controller;

import com.example.demo.pojo.Orders;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public String findOrdersAll(Model model){
        List<Orders> ordersList = ordersService.findAll();
        model.addAttribute("list",ordersList);
        return "showOrders";
    }
}
