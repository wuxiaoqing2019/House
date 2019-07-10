package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import com.kgc.mapper.DistrictMapper;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.DistrictService;
import com.kgc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
   @Autowired
   private StreetMapper streetMapper;
    @Override
    public PageInfo<District> getDistrictByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        DistrictExample districtExample=new DistrictExample();
        List<District> list=districtMapper.selectByExample(districtExample);

        return new PageInfo<District>(list);
    }

    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    @Transactional
    public int deleteDistrict(Integer id) {
         streetMapper.deleteStreetByDid(id);
         districtMapper.deleteByPrimaryKey(id);
         return 1;
    }


    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    public District getDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delMoreDistrict(List<Integer> ids) {
        return districtMapper.delMoreDistrict(ids);
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
