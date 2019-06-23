package com.game.dnf.controller;

import com.game.dnf.pojo.User;
import com.game.dnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AjaxController {
    @Autowired
    UserService userService;

    @RequestMapping("isUsedPhone")
    public String isUsedPhone(@RequestParam("phone")String phone){

        User user = new User();
        user.setPhone(phone);

        boolean flag = userService.checkPhone(user);

        return String.valueOf(flag);

    }


    @RequestMapping("/OtherUserInfo/{uid}")
    public String OtherUserInfo(@PathVariable("uid") Integer uid){
        User user = userService.OtherUserInfo(uid);
        return user.toString();
    }

}
