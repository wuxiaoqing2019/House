package com.kgc.protal.controller;

import com.kgc.entity.District;
import com.kgc.entity.Street;
import com.kgc.service.DistrictService;
import com.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "streetController2")
@RequestMapping("/page/")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getStreetByDid")
    @ResponseBody
    public List<Street> getStreetByDid(Integer id){
        //查询街道
        List<Street> streets=streetService.getAllStreet(id);
        return streets;
    }

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> getAllDistrict(){
        //查询街道
        List<District> districtList = districtService.getAllDistrict();
        return districtList;
    }
}
