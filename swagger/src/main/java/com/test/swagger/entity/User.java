package com.test.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: User
 * @Description: ENTITY
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 16:18
 * @Version: v1.0
 */
@ApiModel("用户信息实体")
public class User {
    @ApiModelProperty("编号")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    public User() {
    }
    public User(Integer id,String name, Integer age) {
        this.id=id;
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
