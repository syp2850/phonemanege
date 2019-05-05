package com.qdu.mobilePhone.service;

import com.qdu.mobilePhone.pojo.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 展示评论信息
     * @param comment
     * @return
     */
    List<Comment> showCom(Comment comment);

    /**
     * 发表评论
     * @param comment
     * @return
     */
    int addCom(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    int delCom(int id);

    /**
     * 删除多条评论
     * @param ids
     * @return
     */
    int delComs(int[] ids);
}
