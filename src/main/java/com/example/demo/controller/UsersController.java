package com.example.demo.controller;

import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    // 页面跳转
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    // 添加用户
    @RequestMapping("/addUser")
    public String addUser(Users users){
        this.usersService.addUser(users);
        return "ok";
    }

    // 查询全体用户
    @RequestMapping("/findUsersAll")
    public String findUsersAll(Model model){
        List<Users> usersAll = this.usersService.findUsersAll();
        model.addAttribute("list",usersAll);
        return "showUsers";
    }

    // 根据用户id查询用户
    @RequestMapping("/findUserById")
    public String findUserById(Integer id, Model model){
        Users userById = this.usersService.findUserById(id);
        model.addAttribute("user",userById);
        return "updateUser";
    }

    // 修改用户信息
    @RequestMapping("/editUser")
    public String editUser(Users users){
        this.usersService.updateUser(users);
        return "redirect:ok";
    }

    // 删除用户信息
    @RequestMapping("/deleteUserById")
    public String deleteUser(Users users){
       return (this.usersService.deleteUser(users)==0)?"error":"ok";
    }

    @RequestMapping("/findOrders")
    public String findOrders(Model model){
        List<Users> ordersAll = usersService.findOrdersAll();
        model.addAttribute("userOrders",ordersAll);
        return "showUsersOrders";
    }
}
