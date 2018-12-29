package com.connext.onlineadmin.service.ServiceImp;

import com.connext.onlineadmin.repository.UserRepository;
import com.connext.onlineadmin.model.User;
import com.connext.onlineadmin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceimp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll(String username) {
        if(StringUtils.isEmpty(username)){
            return this.userRepository.findAll();
        }
        else{
            return this.userRepository.findByUsernameLike(username);
        }

    }

    @Override
    public void changeRole(Integer usertype,Integer id) {
        this.userRepository.updateRole(usertype,id);
    }

    @Override
    @Transactional
    public void deleteOne(Integer id) {
        this.userRepository.delete(id);
    }
}
