package com.example.demo.mapper;

import com.example.demo.pojo.Orders;
import com.example.demo.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Mapper
@Component
public interface UsersMapper {
    @Insert("insert into users(name,age) values (#{name},#{age})")
    void insertUser(Users users);

    @Select("select * from users")
    List<Users> selectUsersAll();

    @Select("select * from users u where u.id = #{uid}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            // 查询 在该用户名下的所有账单
            @Result(column = "id", property = "ordersList", many = @Many(select = "com.example.demo.mapper.OrdersMapper.findOrderById"))
    })
    Users selectUsersById(@Param("uid") Integer uid);

    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    void updateUser(Users user);

    @Delete("delete from users where id=#{id}")
    int deleteUser(Users user);

    @Select("select * from users u")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "ordersList",column = "id",many = @Many(select = "com.example.demo.mapper.OrdersMapper.findOrderById"))
    })
    List<Users> selectAllOrders();

}
