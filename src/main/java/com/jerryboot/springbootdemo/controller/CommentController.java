package com.jerryboot.springbootdemo.controller;

import com.jerryboot.springbootdemo.model.Comment;
import com.jerryboot.springbootdemo.model.Hotel;
import com.jerryboot.springbootdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    //拿到所有評論資料
    @GetMapping("/commentManage")
    public ModelAndView commentList(ModelAndView mav, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                    @RequestParam(name = "commentKeyword",required = false) String keyword){
        Page<Comment> commentByPage = commentService.commentList(pageNumber, keyword);
        List<Comment> list = commentByPage.getContent();
        mav.getModel().put("commentList",list);
        mav.getModel().put("page",commentByPage);
        mav.getModel().put("commentKeyword",keyword);
        mav.setViewName("commentManage");
        return mav;

    }

    //刪除評論
    @GetMapping("/deleteComment")
    public String deleteComment(@RequestParam("commentId") Integer id){
        commentService.deleteComment(id);

        return "redirect:commentManage";
    }

//    ----------------------------------------------------------------------
    //廠商找到評論
    @GetMapping("/firmCommentManage")
    public ModelAndView commentList1(ModelAndView mav, @RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                     @RequestParam(name = "firmCommentKeyword",required = false) String keyword,
                                     HttpSession session){
        Hotel firm = (Hotel) session.getAttribute("loginFirm");
        Page<Comment> page = commentService.findComment(firm.getHotelId(), keyword, pageNumber);
        List<Comment> list = page.getContent();
        mav.getModel().put("commentList",list);
        mav.getModel().put("page",page);
        mav.getModel().put("commentKeyword",keyword);
        mav.setViewName("firmCommentManage");

        return mav;



    }
    //廠商刪除評論
    @GetMapping("/firmDeleteComment")
    public String firmDeleteComment(@RequestParam("commentId") Integer id){
        commentService.deleteComment(id);

        return "redirect:firmCommentManage";
    }

}
