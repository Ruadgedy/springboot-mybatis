package com.example.demo.service.impl;

import com.example.demo.mapper.OrdersMapper;
import com.example.demo.pojo.Orders;
import com.example.demo.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll() {
        return ordersMapper.findAll();
    }
}
