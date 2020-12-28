package cn.kokoda.demo.service;


import cn.kokoda.demo.mapper.UserMapper;
import cn.kokoda.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        List<User> userList = userMapper.selectByUsernameAndPassword(username, password);
        if (!userList.isEmpty()) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean register(String username, String password) {
        return userMapper.insert(new User(null, username, password)) == 1;
    }
}
