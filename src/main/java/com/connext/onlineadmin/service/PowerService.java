package com.connext.onlineadmin.service;


import com.connext.onlineadmin.model.Power;

import java.util.List;

public interface PowerService {
    List<Power> findAll();
    //ɾ��ĳһȨ��
    void deleteOne(Integer id);
    //����ĳһȨ��
    void addPower(Power power);
}
