package com.connext.onlineadmin.service;


import com.connext.onlineadmin.model.Power;

import java.util.List;

public interface PowerService {
    List<Power> findAll();
    //删除某一权限
    void deleteOne(Integer id);
    //新增某一权限
    void addPower(Power power);
}
