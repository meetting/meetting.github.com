package com.teamtwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.RoleMapper;
import com.teamtwo.pojo.Role;
import com.teamtwo.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectAll() {

		return roleMapper.selectAll();
	}

}
