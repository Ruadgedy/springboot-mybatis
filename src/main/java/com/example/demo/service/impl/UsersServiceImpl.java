package com.example.demo.service.impl;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findUsersAll() {
        return this.usersMapper.selectUsersAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return this.usersMapper.selectUsersById(id);
    }

    @Override
    public void updateUser(Users users) {
        this.usersMapper.updateUser(users);
    }

    @Override
    public int deleteUser(Users users) {
        return this.usersMapper.deleteUser(users);
    }

    @Override
    public List<Users> findOrdersAll() {
        List<Users> list = usersMapper.selectAllOrders();
        return list;
    }
}
