package com.connext.onlineadmin.controller;

import com.connext.onlineadmin.model.User;
import com.connext.onlineadmin.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.awt.print.Pageable;

@Controller
@RequestMapping("/mainController")
public class MainController {
    @Resource
    private RoleService roleService;
    @Resource
    private PowerService powerService;
    @Resource
    private RoleReleatedPowerService roleReleatedPowerService;
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;

    @RequestMapping("/toRoleSet")
    public String toRoleSet(Model model, String username){
        model.addAttribute("user",this.userService.findAll(username));
        model.addAttribute("role",this.roleService.findAll());
        return "role";
    }

    @RequestMapping("/toRolePower")
    public String toRolePower(Model model){
        model.addAttribute("powerList",this.powerService.findAll());
        model.addAttribute("roleList",this.roleService.findAll());
        return "role_power";
    }

    @RequestMapping("/toArticleInfo")
    public String toArticleInfo(Model model){
        model.addAttribute("article",this.articleService.queryAllArticle());
        return "article_info";
    }

    @RequestMapping("/toPowerSet")
    public String toPowerSet(Model model){
        model.addAttribute("power",this.powerService.findAll());
        return "power";
    }
}
