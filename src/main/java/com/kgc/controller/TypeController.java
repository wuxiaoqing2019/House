package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.service.TypeService;
import com.kgc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("getType")
    @ResponseBody
public Map<String,Object> getType(Page page){
        PageInfo<Type> pageInfo=typeService.getTypeByPage(page);
        Map<String,Object> objs=new HashMap<>();
        objs.put("total",pageInfo.getTotal());
        objs.put("rows",pageInfo.getList());
        return objs;
    }
@RequestMapping("addType")
    @ResponseBody
    public String getType(Type type){
        int temp=typeService.addType(type);
    return "{\"result\":"+temp+"}";
}
@RequestMapping("getSingleType")
    @ResponseBody
    public Type getType(Integer id){
        return typeService.getType(id);
}
    @RequestMapping("upType")
    @ResponseBody
    public String upType(Type type){
        int temp=typeService.updateType(type);
        return "{\"result\":"+temp+"}";
    }
    @RequestMapping("delType")
    @ResponseBody
    public String delType(Integer id)  {
        int temp=typeService.deleteType(id);
        return "{\"result\":"+temp+"}";
    }
    @RequestMapping("delMoreType")
    @ResponseBody
    public String delMoreType(String id) {//接收编号，名称
        //id=1,2,3,4
        //分割字符串
        String[] arys = id.split(",");
        //转化为List
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arys.length; i++) {
            list.add(Integer.parseInt(arys[i]));
        }
        //调用业务
        int temp = typeService.delMoreType(list);
        return "{\"result\":" + temp + "}";
    }
}
