package com.game.dnf.mapper;

import com.game.dnf.pojo.Badge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 徽章
 */
@Mapper
public interface BadgeMapper {
    //获得所有徽章
    public List<Badge> getUserBadges(int uid);

    //获得所有徽章
    public List<Badge> allBadges();

    //用户获得徽章  uid + bid
    public void insertUserNewBadge(Map map);

    //是否拥有当前徽章
    public int isHavingBadge(Map map);


}
