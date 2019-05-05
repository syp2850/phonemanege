package com.qdu.mobilePhone.service.impl;

import com.qdu.mobilePhone.dao.ActiveDao;
import com.qdu.mobilePhone.pojo.Active;
import com.qdu.mobilePhone.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveServiceImpl implements ActiveService {

    @Autowired
    private ActiveDao activeDao;

    public List<Active> selAllActive(Active active) {
        List<Active> list = activeDao.selActive(null);
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    public int addActive(Active active) {
        int count = activeDao.addActive(active);
        return count;
    }

    public int delActive(Integer id) {
        int count = activeDao.delActive(id);
        return count;
    }

    public int updActive(Active active) {
        int count = activeDao.updActive(active);
        return count;
    }
}
