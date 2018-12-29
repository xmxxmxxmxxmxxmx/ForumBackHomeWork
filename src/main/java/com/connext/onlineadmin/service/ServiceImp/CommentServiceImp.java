package com.connext.onlineadmin.service.ServiceImp;


import com.connext.onlineadmin.model.Comment;
import com.connext.onlineadmin.repository.CommentRepository;
import com.connext.onlineadmin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> queryCommentByArticleId(Integer id) {
        return this.commentRepository.findAllByArticle_Id(id);
    }


    @Override
    public void deleteOneComment(Integer id) {
        this.commentRepository.delete(id);
    }

    @Override
    @Transactional
    public void deleteCommentByUserId(Integer id) {
        this.commentRepository.deleteCommentsByUserId(id);
    }

    @Override
    @Transactional
    public void deleteCommentByArticleId(Integer id) {
        this.commentRepository.deleteCommentsByArticle_Id(id);
    }

}
