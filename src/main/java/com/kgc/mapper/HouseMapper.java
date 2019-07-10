package com.kgc.mapper;

import com.kgc.entity.House;
import com.kgc.entity.HouseExample;
import com.kgc.util.HouseCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    //查询所有出租房信息
    public List<House> getHouseByUserId(Integer uid);

   public House getHouse(String id);

    List<House> getHouseByIsPass(Integer ispass);

    public List<House> getBorswerHouse(HouseCondition condition);
}