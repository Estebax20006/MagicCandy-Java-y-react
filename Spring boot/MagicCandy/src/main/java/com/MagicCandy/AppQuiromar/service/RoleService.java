package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.Role;
import java.util.List;
public interface RoleService {
    public List<Role> findAll() throws Exception;
    public Role findById(int id);
    public void create(Role role);
    public void update(Role role);
    public void delete(Role role);

}