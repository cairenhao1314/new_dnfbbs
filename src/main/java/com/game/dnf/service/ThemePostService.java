package com.game.dnf.service;

import com.game.dnf.mapper.ThemePostMapper;
import com.game.dnf.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemePostService {

    @Autowired
    ThemePostMapper mapper;

    //插入一个新主题贴
    public boolean addThemePost(ThemePost themePost){
        return mapper.insertThemePost(themePost)>0?true:false;
    }

    //查询所有帖子
    public List<ThemePost> allThemePost(){
        return mapper.queryAllThemePost();
    }

    //查询精品帖子 只显示前8条
    public List<ThemePost> goodThemePosts(int tmid){
        return mapper.queryGoodPostsByTmid(tmid);
    }

    //查询一个板块的普通帖子 ThemePage 有板块id  当前页 每页显示的数量
    public List<ThemePost> commonThemePosts(ThemePage page){
        return mapper.queryThemePostsByThemePage(page);
    }

    //查询一个板块有多少帖子
    public int countThemePosts(int tmid){
        return mapper.queryCountThemePostsByTmid(tmid);
    }

    //通过帖子pid 查找帖子
    public ReadThemePost getReadThemePostByPid(int pid){
        return mapper.getReadThemePost(pid);
    }

    //板块对象
    public Theme getThemeByTmid(int tmid){
        return mapper.getTheme(tmid);
    }

    //首页
    public List<ThemePost> getIndexHotPost(){
        return mapper.getHotPosts();
    }

    public List<ThemePost> getIndexNewPost(){
        return mapper.getNewPosts();
    }

    public List<ThemePost> getIndexGoodPost(){
        return mapper.getGoodPosts();
    }

    //点赞帖子
    public boolean addPostLike(int pid){
        return mapper.addPostLike(pid)>0?true:false;
    }

    //查看数+1
    public boolean addPostVisit(int pid){
        return mapper.addPostVisit(pid)>0?true:false;
    }

    //回帖数加一
    public boolean addPostReplynum(int pid){
        return mapper.addPostReplynum(pid)>0?true:false;
    }

    //查找一个用户的所有帖子
    public List<ThemePost> getUserAllThemePosts(int uid){
        return mapper.allUserThemePosts(uid);
    }

    //修改帖子状态 为 精品...
    public void updatePostCase(ThemePost post){
        int pid = post.getPid();
        int pcase = post.getPcase();
        if (pcase == 1) mapper.setGoodPost(pid);
        else if (pcase == 2) mapper.setTopPost(pid);
        else if (pcase == 3) mapper.setHotPost(pid);
    }



}
