package com.game.dnf.controller;


import com.game.dnf.pojo.AddReply;
import com.game.dnf.pojo.ReplyPost;
import com.game.dnf.service.ReplyPostService;
import com.game.dnf.service.ThemePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/reply")
public class ReplyPostController {

    @Autowired
    ReplyPostService service;

    @Autowired
    ThemePostService postService;

    @RequestMapping("/addreply")
    @ResponseBody
    @Transactional
    public Map<String,Object> addreply(@RequestParam("uid")Integer uid, @RequestParam("pid")Integer pid, @RequestParam("to_rpid")Integer to_rpid,
                        @RequestParam("content")String content){
        AddReply addReply = new AddReply(uid, pid, to_rpid, content);

        boolean flag = service.addReply(addReply);

        HashMap<String, Object> map = new HashMap<>();

        String addmsg = "回复成功！";
        if (!flag){
            addmsg = "服务器繁忙，请稍后回复！";
        }

        map.put("msg",addmsg);
        map.put("rpid",addReply.getRpid());

        //回帖数加一
        postService.addPostReplynum(pid);


        return map;
    }

}
