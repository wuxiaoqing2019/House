package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.util.Page;

import java.util.List;

public interface TypeService {
    public PageInfo<Type> getTypeByPage(Page page);
    public int addType(Type type);
    public Type getType(Integer id);
    public int updateType(Type type);
    public int deleteType(Integer id);
    public int delMoreType(List<Integer> ids);
    public List<Type> getAllType();
}
