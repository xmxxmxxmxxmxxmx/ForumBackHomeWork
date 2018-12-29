package com.connext.onlineadmin.service;


import com.connext.onlineadmin.model.RoleReleatedPower;
import java.util.List;

public interface RoleReleatedPowerService {
    public List<RoleReleatedPower> findAll();
    //修改角色的权限
    public Integer addPower(Integer powerId, Integer roleId);
    //删除某一角色的权限
    public void deleteOnePower(Integer powerId,Integer roleId);
    //删除某一个角色同时删除其权限
    public void deleteAllPowersByRoleId(Integer id);
    //删除某一个权限时同时删除角色相关的rrp
    public void deleteAllRolesByPowerId(Integer id);
}
