package com.jerryboot.springbootdemo.service;

import com.jerryboot.springbootdemo.model.Comment;
import com.jerryboot.springbootdemo.model.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    //找到所有評論
    public Page<Comment> commentList(Integer pageNumber,String keyword){
        Pageable pageable = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "commentId");
        if (keyword!=null){
            return commentDao.commentList(keyword, pageable);
        }
            return commentDao.findAll(pageable);
    }

    //刪除評論
    public void deleteComment(Integer id){
        commentDao.deleteCommentByCommentId(id);
    }

}
