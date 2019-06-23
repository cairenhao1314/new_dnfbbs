package com.game.dnf.service;

import com.game.dnf.mapper.ReplyPostMapper;
import com.game.dnf.pojo.AddReply;
import com.game.dnf.pojo.ReplyPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyPostService {

    @Autowired
    ReplyPostMapper mapper;

    /**
     * 查找一个帖子下的所有回帖
     */
    public List<ReplyPost> getAllReplyPosts(int pid){
        return mapper.getAllReplyPostByPid(pid);
    }

    /**
     * 插入一个新的回复帖
     */
    public boolean addReply(AddReply addReply){
        return mapper.insertNewAddReply(addReply)>0?true:false;
    }

}
