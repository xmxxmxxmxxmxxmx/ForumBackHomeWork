package com.connext.onlineadmin.service.ServiceImp;


import com.connext.onlineadmin.repository.RoleReleatedPowerRepository;
import com.connext.onlineadmin.model.RoleReleatedPower;
import com.connext.onlineadmin.service.RoleReleatedPowerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleReleatedPowerServiceImp implements RoleReleatedPowerService {
    @Autowired
    private RoleReleatedPowerRepository roleReleatedPowerRepository;
    @Override
    public List<RoleReleatedPower> findAll() {
        return this.roleReleatedPowerRepository.findAll();
    }

    //更改角色权限
    @Override
    public Integer addPower(Integer powerId,Integer roleId) {
        int flag;
        if(this.roleReleatedPowerRepository.findAllByPowerIdAndRoleId(powerId,roleId)==null){
            this.roleReleatedPowerRepository.saveAll(powerId,roleId);
            flag=2;
        }else {
            flag=3;
        }
        return flag;
    }

    @Override
    @Transactional
    public void deleteOnePower(Integer powerId,Integer roleId) {
        this.roleReleatedPowerRepository.deleteByPower_IdAndRole_Id(powerId,roleId);
    }

    @Override
    @Transactional
    public void deleteAllPowersByRoleId(Integer id) {
        this.roleReleatedPowerRepository.deleteAllByRole_Id(id);
    }

    @Override
    @Transactional
    public void deleteAllRolesByPowerId(Integer id) {
        this.roleReleatedPowerRepository.deleteByPower_Id(id);
    }
}
