package com.jerryboot.springbootdemo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {


    Comment findCommentByCommentId(Integer Id);

    void deleteCommentByCommentId(Integer id);

    @Query("select c from Comment c where concat(c.comment, c.hotel.hotelName, c.room.roomName) like %?1%")
    Page<Comment> commentList(String keyword, Pageable pageable);


    @Query(value = "select count(*) from dbo.Comment",nativeQuery = true)
    Integer commentSum();

    //廠商搜尋自己評論
    @Query("select c from Comment c where concat(c.comment, c.hotel.hotelName, c.room.roomName) like %?1% and c.hotel.hotelId=?2")
    Page<Comment> findCommentByHotel_HotelId(String keyword, Integer id,Pageable pageable);
    //廠商所有評論
    @Query("select c from Comment c where c.hotel.hotelId=?1")
    Page<Comment> findCommentByHotel_HotelId2( Integer id,Pageable pageable);

}
