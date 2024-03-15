package com.MagicCandy.AppQuiromar.service;

import com.MagicCandy.AppQuiromar.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll() throws Exception;
    public User findById(int id);
    public void create(User user);
    public void update(User user);
    public void delete(User user);
}
