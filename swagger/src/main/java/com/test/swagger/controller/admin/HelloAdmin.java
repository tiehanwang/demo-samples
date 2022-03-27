package com.test.swagger.controller.admin;

import com.test.swagger.entity.DataInfo;
import com.test.swagger.entity.User;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: HelloAdmin
 * @Description: Controller
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 14:54
 * @Version: v1.0
 */
@RestController
@Api(tags = "helloAdmin类")
public class HelloAdmin {

    @GetMapping("/helloWorld")
    @ApiOperation("hello测试")
    public String hello(){
        return "hello world!";
    }

    @GetMapping("/get")
    @ResponseBody
    @ApiOperation(value = "get请求测试",notes = "get请求")
    public String get(@ApiParam(required = true,value = "name",example = "张三",name = "name") String name){
        return name;
    }


    @PostMapping("/search")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",required = true,paramType = "query",dataType = "String",dataTypeClass = java.lang.String.class),
            @ApiImplicitParam(name = "id",value = "ID",required = true,paramType = "query",dataType = "Integer",dataTypeClass = Integer.class),
    })
    @ApiOperation("查询姓名测试")
    public String searchName(@RequestParam String name,@RequestParam Integer id){
        return name+" "+id+" ";
    }

    @PostMapping("/add")
    @ApiOperation("测试添加")
    public String add(@ApiParam("这个名字会被返回") User user){
        return user.getName()+":"+user.getAge();
    }

    //返回值的实例都会被添加到swagger 参数上亦可
    @PostMapping("/user")
    @ApiOperation("测试添加")
    public User user(User user){
        return new User();
    }


    @PostMapping("/addsome")
    @ApiOperation("测试添加json")
    public String addSome(@RequestBody User user){
        return user.getName()+":"+user.getAge();
    }
}
