package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.util.HouseCondition;
import com.kgc.util.Page;

import java.util.List;

public interface HouseService {
    public int addHouse(House house);//添加房子
    public PageInfo<House> getHouseByUser(Integer id, Page page);
    //查询出租房信息
    public House getHouse(String id);

    //修改出租房信息
    public int updateHouse(House house);
    public int delHouse(String id,Integer isdel);
    public PageInfo<House> getHouseByIsPass(Page page,Integer ispass);
    public int houseIsPass(String id,Integer ispass);
    public PageInfo<House> getBorswerHouse(HouseCondition condition);

}
