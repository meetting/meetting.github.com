package com.tms.o2o.repository;

import com.tms.o2o.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//地区，数据层接口
@Repository
public interface AreaRepository extends JpaRepository<Area,Integer>{

    //查询所有地区
    public List<Area> findAll();

    //按照areaId查询某个地区
    public Area findByAreaId(Integer areaId);

}
