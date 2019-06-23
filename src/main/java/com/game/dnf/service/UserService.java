package com.game.dnf.service;

import com.game.dnf.mapper.UserMapper;
import com.game.dnf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    /*登录*/
    public User login(User user){
        return mapper.queryUser(user);
    }

    /*注册*/
    public boolean register(User user){
        return mapper.insertUser(user)>0?true:false;
    }

    /*查询手机号是否被注册了*/
    public boolean checkPhone(User user){
        User isUser = mapper.queryUser(user);
        if (isUser == null){
            return true;
        }
        return false;
    }

    /*修改用户信息*/
    public boolean updUser(User user){
        return mapper.updateUser(user)>0?true:false;
    }

    /*按条件查询查询所有用户*/
    public List<User> queryUsers(User user){
        return mapper.queryUsersByRequire(user);
    }

    /*查询所有用户*/
    public List<User> allUsers(){
        return mapper.queryUsers();
    }

    //查询其他用户
    public User OtherUserInfo(int uid){
        return mapper.getNewUser(uid);
    }

}
