package com.example.demo.mapper;

import com.example.demo.pojo.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Mapper
public interface OrdersMapper {

    @Select("select * from orders")
    @Results({@Result(property = "id",column = "id", id = true),
            @Result(property = "total",column = "total"),
            @Result(property = "good",column = "good"),
    @Result(property = "users",column = "uid",one = @One(select = "com.example.demo.mapper.UsersMapper.selectUsersById"))})
    List<Orders> findAll();

    @Select("select * from orders where uid=#{id}")
    List<Orders> findOrderById(@Param("id") Integer id);





}
