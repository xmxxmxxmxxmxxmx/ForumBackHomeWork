package com.connext.onlineadmin.repository;

import com.connext.onlineadmin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<User,Integer> {
    User findByPhone(String phone);
}
