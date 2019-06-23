package com.game.dnf.service;

import com.game.dnf.mapper.BadgeMapper;
import com.game.dnf.pojo.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BadgeService {

    @Autowired
    BadgeMapper mapper;

    //用户获得新勋章
    public void getNewBadge(Map map){
        mapper.insertUserNewBadge(map);
    }

    //获得所有徽章
    public List<Badge> getAllBadges(){
        return mapper.allBadges();
    }

    //用户是否已经拥有当前徽章 true 标识拥有
    public boolean havingThisBadge(Map map){
        return mapper.isHavingBadge(map)>0?true:false;
    }
}
