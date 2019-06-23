package com.game.dnf.service;

import com.game.dnf.mapper.UserPropertyMapper;
import com.game.dnf.pojo.UserProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPropertyService {

    @Autowired
    UserPropertyMapper mapper;

    //自动初始化一个用户的财产表
    public void initUserProperty(int uid){
        mapper.insertUserPropertyByUid(uid);
    }

    //更新用户的财产
    public void updUserProperty(UserProperty property){
        mapper.updateUserProperty(property);
    }

    //查询一个用户的财产  财产数据不存在则初始化一个
    public UserProperty getUserProperty(int uid){
        UserProperty property = mapper.queryUserPropertyByUid(uid);
        if (property == null){
            mapper.insertUserPropertyByUid(uid);
        }
        return mapper.queryUserPropertyByUid(uid);
    }

}
