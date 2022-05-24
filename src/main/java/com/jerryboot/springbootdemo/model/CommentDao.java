package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {


    public Comment findCommentByCommentId(Integer Id);

    public void deleteCommentByCommentId(Integer id);

    @Query("select c from Comment c where concat(c.comment, c.hotel.hotelName, c.room.roomName) like %?1%")
    public Page<Comment> commentList(String keyword, Pageable pageable );
}
