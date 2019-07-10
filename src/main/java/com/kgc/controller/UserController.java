package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.service.UsersService;
import com.kgc.util.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class UserController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("getUser")
    @ResponseBody
    public Map<String,Object> getUser(UserCondition condition){
        PageInfo<Users> pageInfo=usersService.getUsersByPage(condition);
        Map<String,Object> objs=new HashMap<>();
        objs.put("total",pageInfo.getTotal());
        objs.put("rows",pageInfo.getList());
        return objs;
    }


}
