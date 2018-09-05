package com.tms.o2o.service;

import com.tms.o2o.entities.Area;
import com.tms.o2o.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//区域业务层实现
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository areaRepository;

    //查一个
    @Override
    public Area findone(Integer areaId) {
        return areaRepository.findByAreaId(areaId);
    }

    //查所有
    @Override
    public List<Area> findall() {
        return areaRepository.findAll();
    }
}
