package com.game.dnf.mapper;

import com.game.dnf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 插入一个新用户 返回uid
     */
    int insertUser(User user);

    /**
     * 查找用户
     */
    User queryUser(User user);

    /**
     * 查找所有用户
     */
    List<User> queryUsers();

    /**
     * 根据条件查找所有用户
     */
    List<User> queryUsersByRequire(User user);

    /**
     * 修改用户信息
     */
    int updateUser(User user);

    /**
     * 通过用户id查找用户
     */
    User getUserByUid(int uid);

    /**
     * 通过用户id查找其他用户 但是不包括邮箱 手机 密码的信息
     */
    User getOtherUserByUid(int uid);

    /**
     * 获得 有勋章的用户对象
     * @param uid
     * @return
     */
    User getNewUser(int uid);

}
