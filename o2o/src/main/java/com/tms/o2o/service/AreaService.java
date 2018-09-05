package com.tms.o2o.service;

import com.tms.o2o.entities.Area;
import com.tms.o2o.entities.ShopCategory;

import java.util.List;

public interface AreaService {

    //根据areaId查一个
    Area findone (Integer areaId);

    //查所有的
    List<Area> findall();


}
