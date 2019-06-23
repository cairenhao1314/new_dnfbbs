package com.game.dnf.mapper;

import com.game.dnf.pojo.UserProperty;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPropertyMapper {

    //查找一个用户的财产
    public UserProperty queryUserPropertyByUid(int uid);

    //初始化一个用户的财产
    public void insertUserPropertyByUid(int uid);

    //修改一个用户的财产
    public void updateUserProperty(UserProperty property);

}
