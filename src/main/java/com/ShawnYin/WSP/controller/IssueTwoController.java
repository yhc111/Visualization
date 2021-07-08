package com.ShawnYin.WSP.controller;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/issueTwo")
public class IssueTwoController {

    @RequestMapping("/addData")
    public String addData(@RequestBody String shopName)
    {
        System.out.println("**********接收数据测试************");
////        System.out.println(String.valueOf(data.get("user")));
//        System.out.println(request.getParameter("user"));
//        System.out.println(request.getParameter("password"));
        System.out.println(shopName);
        return "Success";

    }
}
