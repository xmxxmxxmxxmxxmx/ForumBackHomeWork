package com.connext.onlineadmin.service;



import com.connext.onlineadmin.model.Comment;

import java.util.List;

public interface CommentService {
    //��������id��ѯ�����й�����
    List<Comment> queryCommentByArticleId(Integer id);
    //����Աɾ������ĳһ��������
    void deleteOneComment(Integer id);
    //����Աɾ���û���ͬʱɾ������
    void deleteCommentByUserId(Integer id);
    //ɾ������ʱͬʱɾ������
    void deleteCommentByArticleId(Integer id);
}
