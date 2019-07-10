package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.service.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getDistrict")
    @ResponseBody
    public Map<String, Object> getDistrict(Page page) {
        PageInfo<District> pageInfo = districtService.getDistrictByPage(page);
        Map<String, Object> objs = new HashMap<>();
        objs.put("total", pageInfo.getTotal());
        objs.put("rows", pageInfo.getList());
        return objs;
    }

    @RequestMapping("addDistrict")
    @ResponseBody
    public String getDistrict(District district) {
        int temp = districtService.addDistrict(district);
        return "{\"result\":" + temp + "}";
    }

    @RequestMapping("getSingleDistrict")
    @ResponseBody
    public District getDistrict(Integer id) {
        return districtService.getDistrict(id);
    }

    @RequestMapping("upDistrict")
    @ResponseBody
    public String upDistrict(District district) {
        int temp = districtService.updateDistrict(district);
        return "{\"result\":" + temp + "}";
    }

@RequestMapping("delDistrict")
    @ResponseBody
    public String delDistrict(Integer id){
        int temp=districtService.deleteDistrict(id);
    return "{\"result\":" + temp + "}";
}
@RequestMapping("delMoreDistrict")
    @ResponseBody
    public String delMoreDistrict(String id) {
    //分割字符串
    String[] arys = id.split(",");
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < arys.length; i++) {
           list.add(Integer.parseInt(arys[i]));
    }
    int temp=districtService.delMoreDistrict(list);
    return "{\"result\":" + temp + "}";

}
}