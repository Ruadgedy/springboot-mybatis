package com.example.demo.pojo;

import lombok.Data;

import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Data
public class Users {
    private Integer id;
    private String name;
    private Integer age;

    // 当前用户具有的订单
    private List<Orders> ordersList;
}
