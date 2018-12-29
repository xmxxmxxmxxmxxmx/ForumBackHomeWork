package com.connext.onlineadmin.service;

import com.connext.onlineadmin.model.Article;

import java.util.List;

public interface ArticleService {
    //��ѯ���е����·����б���
    List<Article> queryAllArticle();
    //��ѯ���¾������ݣ��������µ�����
    Article queryOneArticleDetail(Integer articleId);
    //����Աɾ��ĳһƪ����
    void deleteOne(Integer id);
    //�����û���idɾ���û�������
    void deleteArticleByUserId(Integer id);
}
