package com.example.demo;

import com.example.demo.mapper.OrdersMapper;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	OrdersMapper ordersMapper;

	@Autowired
	UsersMapper usersMapper;


	@Test
	void contextLoads() {
	}

	@Test
	public void test(){
		List<Orders> orders = ordersMapper.findAll();
		for (Orders order : orders) {
			System.out.println(order);
		}
	}

	@Test
	public void test2(){
		List<Users> list = usersMapper.selectAllOrders();
		for (Users user : list) {
			System.out.println(user);
		}
	}

}
