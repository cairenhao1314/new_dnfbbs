package com.game.dnf.controller;

import com.game.dnf.pojo.Badge;
import com.game.dnf.pojo.ThemePost;
import com.game.dnf.pojo.User;
import com.game.dnf.pojo.UserProperty;
import com.game.dnf.service.BadgeService;
import com.game.dnf.service.ThemePostService;
import com.game.dnf.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 页面跳转
 */
@Controller
public class PageSkipController {

    @Autowired
    ThemePostService service;

    @Autowired
    BadgeService badgeService;

    @Autowired
    UserPropertyService propertyService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav){
        List<ThemePost> goodPosts = service.getIndexGoodPost();
        List<ThemePost> hotPosts = service.getIndexHotPost();
        List<ThemePost> newPosts = service.getIndexNewPost();

        mav.setViewName("index");

        mav.addObject("goodtop",goodPosts.remove(0));
        mav.addObject("goodposts",goodPosts);

        mav.addObject("hottop",hotPosts.remove(0));
        mav.addObject("hotposts",hotPosts);

        mav.addObject("newtop",newPosts.remove(0));
        mav.addObject("newposts",newPosts);

        return mav;
    }

    @RequestMapping("/posts")
    public ModelAndView posts(ModelAndView mav, HttpSession session){
        mav.setViewName("posts");
        mav.addObject("tmid",2);
        User user = new User();
        user.setUid(1);
        session.setAttribute("user",user);

        List<ThemePost> themePosts = service.allThemePost();

        mav.addObject("themePosts",themePosts);


        return mav;
    }





    @RequestMapping("/uinfo")
    public String uinfo(){
        return "user/personalproperty";
    }

    //勋章页面
    @RequestMapping("/badge")
    public ModelAndView badge(ModelAndView mav,HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user != null){
            UserProperty property = propertyService.getUserProperty(user.getUid());
            mav.addObject("property",property);
        }
        List<Badge> badges = badgeService.getAllBadges();
        mav.addObject("badges",badges);
        mav.setViewName("badge");

        return mav;
    }




}
