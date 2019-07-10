package com.kgc.service;


import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.util.Page;

import java.util.List;

public interface DistrictService {
    public PageInfo<District> getDistrictByPage(Page page);
    public int addDistrict(District district);
    public int deleteDistrict(Integer id);
    public int updateDistrict(District district);
    public District getDistrict(Integer id);
    public int delMoreDistrict(List<Integer> ids);
    public List<District> getAllDistrict();
}
