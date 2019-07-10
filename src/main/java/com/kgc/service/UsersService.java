package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.Users;
import com.kgc.util.Page;
import com.kgc.util.UserCondition;

import java.util.List;

public interface UsersService {
    public PageInfo<Users> getUsersByPage(UserCondition condition);
    public int checkUserName(String name);
    //注册用户
    public int addUser(Users user);
    //实现登入   通过用户密码去查询数据库
    public Users login(String username,String password);

}
