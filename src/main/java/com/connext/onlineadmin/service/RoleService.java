package com.connext.onlineadmin.service;

import com.connext.onlineadmin.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    void deleteoneRole(Integer id);
    //新增角色
    void addRole(Role role);
}
