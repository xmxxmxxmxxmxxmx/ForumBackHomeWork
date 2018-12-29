package com.connext.onlineadmin.service;

import com.connext.onlineadmin.model.User;

import java.util.List;

public interface UserService {
    //查询所有的用户
    public List<User> findAll(String username);
    //更改用户角色
    void changeRole(Integer usertype,Integer id);
    //管理员删除用户
    void deleteOne(Integer id);
}
