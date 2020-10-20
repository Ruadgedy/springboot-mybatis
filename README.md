## 这是springboot整合mybatis的小项目
### mybatis采用注解模式
### 使用了一对一 @one 和一对多 @many 方式

## 简要介绍
> pojo对象有两个，分别是Orders和Users，如下所示
```java
public class Orders {
    private Integer id;
    private Double total;
    private String good;

    private Users users;
}

public class Users {
    private Integer id;
    private String name;
    private Integer age;

    // 当前用户具有的订单
    private List<Orders> ordersList;
}
```
> mapper注解如下：
```java
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

@Mapper
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
```
