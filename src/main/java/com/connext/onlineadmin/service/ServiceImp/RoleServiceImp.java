package com.connext.onlineadmin.service.ServiceImp;

import com.connext.onlineadmin.repository.RoleRepository;
import com.connext.onlineadmin.model.Role;
import com.connext.onlineadmin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public void deleteoneRole(Integer id) {
        this.roleRepository.delete(id);
    }

    @Override
    public void addRole(Role role) {
        this.roleRepository.save(role);
    }
}
