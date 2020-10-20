package com.example.demo.service;

import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;

import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
public interface UsersService {
    void addUser(Users users);
    List<Users> findUsersAll();
    Users findUserById(Integer id);
    void updateUser(Users users);
    int deleteUser(Users users);
    List<Users> findOrdersAll();
}
