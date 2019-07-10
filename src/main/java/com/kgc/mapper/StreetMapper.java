package com.kgc.mapper;

import com.kgc.entity.Street;
import com.kgc.entity.StreetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StreetMapper {
    int countByExample(StreetExample example);

    int deleteByExample(StreetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Street record, @Param("example") StreetExample example);

    int updateByExample(@Param("record") Street record, @Param("example") StreetExample example);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    //通过区域删除街道
    int deleteStreetByDid(Integer id);
}