package com.qdu.mobilePhone.dao;

import com.qdu.mobilePhone.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CommentDao {

    /**
     * 查询评论
     * @return
     */
    List<Comment> selCom(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    int delCom(int id);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    int addCom(Comment comment);

}
