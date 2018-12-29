package com.connext.onlineadmin.repository;

import com.connext.onlineadmin.model.RoleReleatedPower;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface RoleReleatedPowerRepository extends JpaRepository<RoleReleatedPower,Integer> {
    //@Query("select r from RoleReleatedPower r where r.powerId=?1 and r.roleId=?2")
    RoleReleatedPower findAllByPowerIdAndRoleId(Integer powerId, Integer roleId);

    @Modifying
    @Query(value = "insert into role_releated_power(power_id,role_id) values(?1,?2)",nativeQuery = true)
    void saveAll(Integer powerId,Integer roleId);

    void deleteByPower_IdAndRole_Id(Integer powerId, Integer roleId);

    //删除某一个角色同时删除它的权限
    @Modifying
    @Query(value = "delete from role_releated_power where role_id=?1",nativeQuery = true)
    void deleteAllByRole_Id(Integer id);

    //删除某一个权限时同时删除角色相关的rrp
    @Modifying
    @Query(value = "delete from role_releated_power where power_id=?1",nativeQuery = true)
    void deleteByPower_Id(Integer id);
}
