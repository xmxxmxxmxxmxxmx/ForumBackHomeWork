package com.connext.onlineadmin.service.ServiceImp;

import com.connext.onlineadmin.repository.ArticleRepository;
import com.connext.onlineadmin.model.Article;
import com.connext.onlineadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> queryAllArticle() {
        return this.articleRepository.findAllByOrderByDate();
    }
    @Override
    public Article queryOneArticleDetail(Integer articleId) {
        return this.articleRepository.getOne(articleId);
    }

    @Override
    public void deleteOne(Integer id) {
        this.articleRepository.delete(id);
    }

    @Override
    @Transactional
    public void deleteArticleByUserId(Integer id) {
        this.articleRepository.deleteAllByUser_Id(id);
    }
}
