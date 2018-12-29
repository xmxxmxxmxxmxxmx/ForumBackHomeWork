package com.connext.onlineadmin.controller;

import com.connext.onlineadmin.service.ArticleService;
import com.connext.onlineadmin.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Controller
    @RequestMapping("/articleController")
    public class ArticleController {
        @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    //管理员删除文章
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id){
        //删除文章时同时删除文章所有评论
        this.commentService.deleteCommentByArticleId(id);
        this.articleService.deleteOne(id);
        return "redirect:/mainController/toArticleInfo";
    }

    @RequestMapping("/articleDetail")
    public String articleDetail(String articleId, Model model, HttpSession session){
        session.setAttribute("articleId",articleId);
        model.addAttribute("comment",this.commentService.queryCommentByArticleId(Integer.parseInt(articleId)));
        model.addAttribute("article",this.articleService.queryOneArticleDetail(Integer.parseInt(articleId)));
        return "article_detail";
    }

    //管理员删除文章的某一个评论
    @RequestMapping("/deleteComment")
    public String deleteMyComment(Integer commentId, HttpSession session, RedirectAttributes redirectAttributes){
        this.commentService.deleteOneComment(commentId);
        redirectAttributes.addAttribute("articleId",session.getAttribute("articleId").toString());
        return "redirect:/articleController/articleDetail";
    }
}
