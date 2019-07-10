package com.kgc.service;


import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.util.Page;

import java.util.List;


public interface StreetService {

    //查询某区域下的街道
    PageInfo<Street> getStreetByDid(Integer id, Page page);
    List<Street> getAllStreet(Integer id);
}
