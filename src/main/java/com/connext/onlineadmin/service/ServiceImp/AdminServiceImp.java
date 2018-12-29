package com.connext.onlineadmin.service.ServiceImp;

import com.connext.onlineadmin.repository.AdminRepository;
import com.connext.onlineadmin.model.User;
import com.connext.onlineadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Integer login(User user) {
        //0:   1：  2：
        Integer flag = 1;
        if (adminRepository.findByPhone(user.getPhone()) != null) {
            if (adminRepository.findByPhone(user.getPhone()).getPassword().equals(this.convertMD5(user.getPassword())) && adminRepository.findByPhone(user.getPhone()).getUsertype()==1) {
                flag = 2;
            }
        }
        return flag;
    }

    // md5编码
    public static String convertMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;

    }
}
