package com.qdu.mobilePhone.service.impl;

import com.qdu.mobilePhone.dao.CommentDao;
import com.qdu.mobilePhone.pojo.Comment;
import com.qdu.mobilePhone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<Comment> showCom(Comment comment) {
        List<Comment> list = commentDao.selCom(comment);
        return list;
    }

    public int addCom(Comment comment) {
        int count = commentDao.addCom(comment);
        return 0;
    }

    public int delCom(int id) {
        Integer total = commentDao.selCom(null).size();
        if(id >0 && id <= total){
            return commentDao.delCom(id);
        }
        return 0;
    }

    public int delComs(int[] ids) {
        Integer total = commentDao.selCom(null).size();
        int count = 0;
        if(ids.length > 0){
            for (int id : ids){
                if(id >0 && id <= total){
                    count += commentDao.delCom(id);
                }
            }
            if(count == ids.length){
                return count; //全部删除成功
            }
            return count; //未全部删除成功
        }
        return 0; //全部删除失败
    }
}
