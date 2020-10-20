package com.example.demo.service.impl;

import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;
import com.example.demo.service.OrdersService;
import com.example.demo.service.UsersService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author :  yuhao
 * @date: 2020/10/20
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class OrdersServiceImplTest {

    @Autowired
    OrdersService ordersService;

    @Autowired
    UsersService usersService;

    @Test
    void findAll() {
        List<Orders> all = ordersService.findAll();
        System.out.println(all);
    }

    @Test
    public void findUserById(){
        System.out.println(usersService.findUserById(1));
    }

    @Test
    public void selectAllOrders(){
        List<Users> ordersAll = usersService.findOrdersAll();
        System.out.println(ordersAll);
    }
}
