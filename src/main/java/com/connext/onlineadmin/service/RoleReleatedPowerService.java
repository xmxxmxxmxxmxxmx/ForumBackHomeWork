package com.connext.onlineadmin.service;


import com.connext.onlineadmin.model.RoleReleatedPower;
import java.util.List;

public interface RoleReleatedPowerService {
    public List<RoleReleatedPower> findAll();
    //�޸Ľ�ɫ��Ȩ��
    public Integer addPower(Integer powerId, Integer roleId);
    //ɾ��ĳһ��ɫ��Ȩ��
    public void deleteOnePower(Integer powerId,Integer roleId);
    //ɾ��ĳһ����ɫͬʱɾ����Ȩ��
    public void deleteAllPowersByRoleId(Integer id);
    //ɾ��ĳһ��Ȩ��ʱͬʱɾ����ɫ��ص�rrp
    public void deleteAllRolesByPowerId(Integer id);
}
