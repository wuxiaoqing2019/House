package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.mapper.HouseMapper;
import com.kgc.service.HouseService;
import com.kgc.util.HouseCondition;
import com.kgc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer id, Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有记录
        List<House> list=houseMapper.getHouseByUserId(id);
        return new PageInfo<House>(list);

    }

    @Override
    public House getHouse(String id) {
        return houseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id, Integer isdel) {
        //创建出租房实体
        House house=new House();
        house.setId(id);
        house.setIsdel(isdel);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByIsPass(Page page, Integer ispass) {
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有
        List<House> list=houseMapper.getHouseByIsPass(ispass);
        return new PageInfo<>(list);
    }

    @Override
    public int houseIsPass(String id, Integer ispass) {
        House house=new House();
        house.setId(id);
        house.setIspass(ispass);

        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBorswerHouse(HouseCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getRows());
        List<House> list=houseMapper.getBorswerHouse(condition);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


}
