package com.gai.springsecuritydba.dao;

import com.gai.springsecuritydba.entity.Role;
import com.gai.springsecuritydba.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by gaigaicoming on 2019/10/29.
 */
@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
}
