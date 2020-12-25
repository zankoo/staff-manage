package cn.kokoda.demo.service;


import cn.kokoda.demo.mapper.UserMapper;
import cn.kokoda.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean login(String username, String password) {
        return !userMapper.selectByUsernameAndPassword(username, password).isEmpty();
    }

    public boolean register(String username, String password) {
        return userMapper.insert(new User(null, username, password)) == 1;
    }
}
