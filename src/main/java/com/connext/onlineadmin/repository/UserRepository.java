package com.connext.onlineadmin.repository;

import com.connext.onlineadmin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Modifying
    @Query(value = "update User u set u.usertype=?1 where u.id=?2")
    void updateRole(Integer usertype,Integer id);

    @Query(value = "select u from User u where 1=1 and u.username like concat('%',?1,'%')")
    List<User> findByUsernameLike(String username);

}
