package com.example.demo.pojo;

import lombok.Data;

/**
 * Author :  冯宇豪
 * Date:     2020/7/15
 * Description:
 */
@Data
public class Orders {
    private Integer id;
    private Double total;
    private String good;

    private Users users;
}
