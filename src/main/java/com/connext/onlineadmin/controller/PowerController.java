package com.connext.onlineadmin.controller;

import com.connext.onlineadmin.model.Power;
import com.connext.onlineadmin.service.PowerService;
import com.connext.onlineadmin.service.RoleReleatedPowerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/powerController")
public class PowerController {
    @Resource
    private PowerService powerService;
    @Resource
    private RoleReleatedPowerService roleReleatedPowerService;

    //删除某一个权限
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id){
        this.powerService.deleteOne(id);
        //删除某一个权限时同时删除角色相关的rrp
        this.roleReleatedPowerService.deleteAllRolesByPowerId(id);
        return "redirect:/mainController/toPowerSet";
    }

    //新增某一权限
    @RequestMapping("/addPower")
    public String addPower(Power power){
        this.powerService.addPower(power);
        return "redirect:/mainController/toPowerSet";
    }
}
