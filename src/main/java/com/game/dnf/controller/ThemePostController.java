package com.game.dnf.controller;

import com.game.dnf.pojo.*;
import com.game.dnf.service.ReplyPostService;
import com.game.dnf.service.ThemePostService;
import com.game.dnf.service.UserPropertyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/themepost")
public class ThemePostController {

    @Autowired
    ThemePostService service;

    @Autowired
    ReplyPostService replyPostService;

    @Autowired
    UserPropertyService propertyService;

    //异步发表主题帖
    @RequestMapping("/addThemePost")
    @ResponseBody
    public Map<String,Object> addThemePost(@RequestParam("title")String title,
                               @RequestParam("content")String content,
                               @RequestParam("tmid")Integer tmid,
                               @RequestParam("tyid")Integer tyid,
                               @RequestParam("uid")Integer uid){
        ThemePost themePost = new ThemePost();

        User author = new User();
        author.setUid(uid);
        themePost.setAuthor(author);

        Theme theme = new Theme();
        theme.setTmid(tmid);
        themePost.setTheme(theme);

        Type type = new Type();
        type.setTyid(tyid);
        themePost.setType(type);

        themePost.setTitle(title);
        themePost.setContent(content);

        boolean flag = service.addThemePost(themePost);

        //用户金币减一
        UserProperty updpro = new UserProperty(uid,+1);
        propertyService.updUserProperty(updpro);

        String msg = "发表成功!  金币 + 1";

        if (!flag){
            msg = "出现异常，发表失败！";
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("pid",themePost.getPid());

        return map;
    }

    //某一页的帖子数据
    @RequestMapping("/loadThemePostsByPage/{tmid}/{pageNum}")
    public ModelAndView loadThemePostsByPage(@PathVariable("tmid") Integer tmid, @PathVariable("pageNum") Integer pageNum,
                                             ModelAndView mav){

        //加精 置顶 热帖
        List<ThemePost> goodThemePosts = service.goodThemePosts(tmid);
        //普通帖子
        List<ThemePost> commonThemePosts = service.commonThemePosts(new ThemePage(tmid, pageNum, 25));
        //查看有多少帖子
        int count = service.countThemePosts(tmid);
        //板块对象
        Theme theme = service.getThemeByTmid(tmid);

        mav.addObject("goodThemePosts",goodThemePosts);
        mav.addObject("themePosts",commonThemePosts);
        mav.addObject("tmid",tmid);
        mav.addObject("curr",pageNum);
        mav.addObject("count",count);
        mav.addObject("theme",theme);

        mav.setViewName("posts");

        return mav;

    }

    //查看某个帖子
    @RequestMapping("/readpost/{pid}")
    @Transactional
    public ModelAndView readpost(@PathVariable("pid") Integer pid,ModelAndView mav){

        mav.setViewName("postinfo");

        ReadThemePost readPost = service.getReadThemePostByPid(pid);

        //System.out.println(readPost.getThemePost().getAuthor().getBadges());

        //访问量加一
        service.addPostVisit(pid);

        List<ReplyPost> replyPosts = readPost.getReplyPosts();

        //按时间排序
        for (ReplyPost replyPost : replyPosts) {
            replyPost.getSonList();
            Collections.sort(replyPost.getReplyPosts(),new TimeComparator());
        }

        mav.addObject("readPost",readPost);

        return mav;
    }

    @RequestMapping("/addlikepost")
    @ResponseBody
    public String addlikepost(@RequestParam("pid") Integer pid){
        //执行点赞
        boolean flag = service.addPostLike(pid);
        if (flag){
            return "点赞成功！";
        }
        return "点赞失败！";
    }

    @RequestMapping("/setGood/{pid}")
    @ResponseBody
    public String setGood(@PathVariable("pid")Integer pid){
        ThemePost themePost = new ThemePost();
        themePost.setPcase(1);
        themePost.setPid(pid);
        service.updatePostCase(themePost);
        return "加精成功！";
    }

    @RequestMapping("/setHot/{pid}")
    @ResponseBody
    public String setHot(@PathVariable("pid")Integer pid){
        ThemePost themePost = new ThemePost();
        themePost.setPcase(3);
        themePost.setPid(pid);
        service.updatePostCase(themePost);
        return "设置热帖成功！";
    }

    @RequestMapping("/setTop/{pid}")
    @ResponseBody
    public String setTop(@PathVariable("pid")Integer pid){
        ThemePost themePost = new ThemePost();
        themePost.setPcase(2);
        themePost.setPid(pid);
        service.updatePostCase(themePost);
        return "置顶成功！";
    }

}
