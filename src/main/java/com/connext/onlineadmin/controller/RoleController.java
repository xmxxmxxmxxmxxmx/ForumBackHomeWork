package com.connext.onlineadmin.controller;

import com.connext.onlineadmin.model.Role;
import com.connext.onlineadmin.service.RoleReleatedPowerService;
import com.connext.onlineadmin.service.RoleService;
import com.connext.onlineadmin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Controller
@RequestMapping("/roleController")
public class RoleController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private RoleReleatedPowerService roleReleatedPowerService;

    //更改用户角色
    @Transactional
    @RequestMapping("/changeRole")
    public String changeRole(Integer usertype,Integer id){
        this.userService.changeRole(usertype,id);
        return "redirect:usercontroller/toRole";
    }

    //删除某一个角色
    @RequestMapping("/deleteOneRole")
    public String deleteOneRole(Integer id){
        this.roleService.deleteoneRole(id);
        //删除某一个角色同时删与其有关的所有权限
        this.roleReleatedPowerService.deleteAllPowersByRoleId(id);
        return "redirect:/mainController/toRolePower";
    }

    //新增用户角色
    @RequestMapping("/addRole")
    @ResponseBody
    public Integer addRole(Role role){
        Integer flag=0;
        if (StringUtils.isNotEmpty(role.getRolename())){
            this.roleService.addRole(role);
            flag=1;
        }
        return flag;
    }

    //增加用户权限
    @Transactional
    @RequestMapping("/addPowerOfRole")
    @ResponseBody
    public Integer addPowerOfRole(Integer powerId,Integer roleId){
        int flag;
        if(StringUtils.isEmpty(powerId.toString())||StringUtils.isEmpty(roleId.toString())){
            flag=1;
        }else{
            flag=this.roleReleatedPowerService.addPower(powerId,roleId);
        }
        return flag;
    }

    //删除某一个角色的权限
    @RequestMapping("/deleteOnePower")
    public String deleteOnePower(Integer powerId,Integer roleId){
        this.roleReleatedPowerService.deleteOnePower(powerId,roleId);
        return "redirect:/mainController/toRolePower";
    }


}
