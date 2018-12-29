package com.connext.onlineadmin.controller;

import com.connext.onlineadmin.service.ArticleService;
import com.connext.onlineadmin.service.CommentService;
import com.connext.onlineadmin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    //管理员删除用户
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id){
        //删除用户表中的用户
        this.userService.deleteOne(id);
        //删除用户时同时删除文章表中该用户的所有文章
        this.articleService.deleteArticleByUserId(id);
        //删除用户时同时删除评论表中该用户的所有评论
        this.commentService.deleteCommentByUserId(id);
        return "redirect:/mainController/toRoleSet";
    }
}
