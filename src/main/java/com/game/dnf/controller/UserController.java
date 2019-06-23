package com.game.dnf.controller;

import com.game.dnf.pojo.ThemePost;
import com.game.dnf.pojo.User;
import com.game.dnf.pojo.UserProperty;
import com.game.dnf.service.BadgeService;
import com.game.dnf.service.ThemePostService;
import com.game.dnf.service.UserPropertyService;
import com.game.dnf.service.UserService;
import com.game.dnf.util.FileUtil;
import com.game.dnf.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    UserPropertyService propertyService;

    @Autowired
    ThemePostService postService;

    @Autowired
    BadgeService badgeService;

    @RequestMapping("/login")
    public ModelAndView login(User user, ModelAndView mav, HttpSession session){

        //登录业务
        User login = service.login(user);
        //System.out.println("login" + login);

        if (login == null){
            mav.setViewName("login");
            mav.addObject("loginMsg","账号或者密码错误！");
            return mav;
        }

        //判断用户的状态
        if (login.getUstatus() != 1){
            String loginMsg = "";
            if (login.getUstatus() == 2){
                loginMsg = "登录失败，您的账号已被封禁！";
            }else if(login.getUstatus() == -1){
                loginMsg = "登录失败,您的账号未被激活！";
            }
            mav.setViewName("login");
            mav.addObject("loginMsg",loginMsg);
            return mav;
        }

        //登录成功
        session.setAttribute("user",login);
        mav.setViewName("forward:/index");

        return mav;
    }

    @RequestMapping("/register")
    public ModelAndView register(ModelAndView mav,User user){
        //账号注册业务
        service.register(user);

        //发送邮件验证 启动一个线程
        new Thread(new MailUtil(user.getEmail(), user.getUid())).start();

        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("/activate/{uid}")
    public ModelAndView activate(ModelAndView mav, @PathVariable Integer uid){
        User user = new User();
        user.setUid(uid);
        //设置用户的状态为激活状态
        user.setUstatus(1);

        //激活账号
        service.updUser(user);

        //跳转至登录页面
        mav.setViewName("login");
        return mav;

    }

    @RequestMapping(value = "/uploadhead", method = RequestMethod.POST)
    public String upload(HttpSession session,@RequestParam("headphoto") MultipartFile file,@RequestParam("signature")String signature){
        try {
            //上传后的地址，注意("/upload")是表示文件上传后的目标文件夹
            String realPath = session.getServletContext().getRealPath("/img/upload");
            System.out.println("真实项目路径：" + realPath);

            //父文件夹
            File father = new File(realPath);

            //获取文件名
            String filename = file.getOriginalFilename();
            //获取文件后缀名
            String extensionname = filename.substring(filename.lastIndexOf(".") + 1);
            //给上传的文件起别名，有很多种方式
            String newFilename=String.valueOf(System.currentTimeMillis())+"."+extensionname;
            //创建File对象，传入目标路径参数，和新的文件别名
            File dir=new File(realPath,newFilename);

            //复制一份到本地
            File local = new File("D:\\DNFfacedb",newFilename);

            if (!father.exists()){
                //如果dir代表的文件不存在，则创建它，
                father.mkdirs();//
            }
            //如果存在则直接执行下面操作
            file.transferTo(dir);//将上传的实体文件复制到指定目录upload下

            //复制到本地
            FileUtil.copy(dir,new File("D:\\DNFfacedb"),false);

            User user = (User)session.getAttribute("user");

            user.setHeadphoto(newFilename);
            user.setSignature(signature);

            //更新session中值
            session.setAttribute("user",user);

            //修改用户的信息
            service.updUser(user);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "forward:/index";
    }

    @RequestMapping("/info")
    public String info(){
        return "/user/personal";
    }

    //跳转至积分页面
    @RequestMapping("/points")
    public String points(){
        return "/user/personalproperty";
    }

    //退出登录
    @RequestMapping("/loginout")
    @ResponseBody
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "您已安全退出！";
    }

    //查看其它用户个人情况
    @RequestMapping("/viewothers/{uid}")
    public ModelAndView viewohters(@PathVariable("uid")Integer uid,ModelAndView mav){
        UserProperty property = propertyService.getUserProperty(uid);
        if (property == null) {
            propertyService.initUserProperty(uid);
            property = propertyService.getUserProperty(uid);
        }

        mav.addObject("property",property);

        User other = service.OtherUserInfo(uid);

        mav.addObject("other",other);

        mav.setViewName("antherinfo");

        return mav;

    }

    //其他人的帖子
    @RequestMapping("/antherPosts/{uid}")
    public ModelAndView antherPosts(@PathVariable("uid")Integer uid,ModelAndView mav){
        List<ThemePost> posts = postService.getUserAllThemePosts(uid);

        mav.addObject("posts",posts);

        User other = service.OtherUserInfo(uid);

        mav.addObject("other",other);

        mav.setViewName("antherpost");

        return mav;
    }

    //查看自己的财产
    @RequestMapping("/myProperty")
    public ModelAndView myProperty(HttpSession session,ModelAndView mav){
        User user = (User)session.getAttribute("user");
        user = new User(1);
        if (user != null){
            int uid = user.getUid();
            UserProperty property = propertyService.getUserProperty(uid);
            if (property == null) {
                propertyService.initUserProperty(uid);
                property = propertyService.getUserProperty(uid);
            }

            mav.addObject("property",property);
            mav.setViewName("/user/personalproperty");
        }
        return mav;
    }

    //修改自己的密码
    @RequestMapping("/changePwd")
    public String  changePwd(){
        return "/user/personalpwd";
    }



    //修改自己密码 异步
    @RequestMapping("/updpwd")
    @ResponseBody
    public String updpwd(@RequestParam("oldpwd")String oldpwd,@RequestParam("newpwd")String newpwd,HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user.getPwd().equals(oldpwd)){
            user.setPwd(newpwd);
            boolean flag = service.updUser(user);
            return flag?"修改成功！":"出现异常错误！";
        }
        return "旧密码错误！";
    }

    //购买勋章 业务
    @RequestMapping("/buyBadge/{bid}")
    @ResponseBody
    @Transactional
    public String buyBadge(@PathVariable("bid")Integer bid,HttpSession session){

        User user = (User)session.getAttribute("user");

        UserProperty property = propertyService.getUserProperty(user.getUid());
        //如果金币大于等于1
        if (property.getGoldcoin()>0){

            HashMap<String, Integer> map = new HashMap<>();
            map.put("uid",user.getUid());
            map.put("bid",bid);

            boolean flag = badgeService.havingThisBadge(map);
            if (flag){
                return "您已拥有当前徽章，请不要重复购买！";
            }
            //购买徽章
            badgeService.getNewBadge(map);

            //用户金币减一
            UserProperty updpro = new UserProperty(user.getUid(),-1);
            propertyService.updUserProperty(updpro);
            return "购买成功！";
        }else{
            return "金币不足！";
        }

    }

}
