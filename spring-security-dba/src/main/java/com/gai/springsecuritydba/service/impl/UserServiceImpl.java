package com.gai.springsecuritydba.service.impl;


import com.gai.springsecuritydba.dao.UserMapper;
import com.gai.springsecuritydba.entity.User;
import com.gai.springsecuritydba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by gaigaicoming on 2019/10/21.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.loadUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("账户不存在!");
        }
        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        return user;
    }
}
