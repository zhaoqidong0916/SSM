package com.haitai.service;

import com.haitai.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    List<User> findAll();

    User findOne(long id);

    int update(User user);

    int delete(long id);

    int insert(User user);

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

    User getUserById(long userId);
}
