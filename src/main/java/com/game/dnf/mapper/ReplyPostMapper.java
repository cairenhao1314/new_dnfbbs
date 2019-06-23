package com.game.dnf.mapper;

import com.game.dnf.pojo.AddReply;
import com.game.dnf.pojo.ReplyPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyPostMapper {

    /**
     * 一个帖子所有回复贴
     */
    public List<ReplyPost> getAllReplyPostByPid(int pid);

    /**
     * 通过回帖id 查找回帖对象集合
     */
    public List<ReplyPost> getAllReplyPostByRpid(int rpid);

    /**
     * 添加一个新的回复帖
     */
    public int insertNewAddReply(AddReply addReply);

}
