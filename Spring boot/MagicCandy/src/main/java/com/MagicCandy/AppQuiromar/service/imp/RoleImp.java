package com.MagicCandy.AppQuiromar.service.imp;

import com.MagicCandy.AppQuiromar.entity.Role;
import com.MagicCandy.AppQuiromar.repository.RoleRepository;
import com.MagicCandy.AppQuiromar.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() throws Exception{
        return this.roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return this.roleRepository.findById(id);
    }

    @Override
    public void create(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }
}
