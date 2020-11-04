package com.haitai.service.impl;

import com.haitai.mapper.UserMapper;
import com.haitai.pojo.User;
import com.haitai.pojo.UserExample;
import com.haitai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {

        return userMapper.selectByExample(null);
    }

    /**
     * 测试专用 查询一个
     * @param id
     * @return
     */
    @Override
    public User findOne(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 测试更新数据
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    /**
     * 测试，根据id删除
     * @param id
     * @return
     */
    @Override
    public int delete(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 测试，插入新的数据
     * @param user
     * @return
     */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 测试，根据姓名查询当前人信息
     * @param name
     * @return
     */
    @Override
    public List<User> findByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return userMapper.selectByExample(example);
    }

    /**
     * 测试，根据age查询成员
     * @param age
     * @return
     */
    @Override
    public List<User> findByAge(Integer age) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAgeEqualTo(age);
        return userMapper.selectByExample(example);
    }

    @Override
    public User getUserById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


}
