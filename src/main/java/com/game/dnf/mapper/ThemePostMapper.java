package com.game.dnf.mapper;

import com.game.dnf.pojo.ReadThemePost;
import com.game.dnf.pojo.Theme;
import com.game.dnf.pojo.ThemePage;
import com.game.dnf.pojo.ThemePost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemePostMapper {

    //添加一个主题帖
    public int insertThemePost(ThemePost post);

    //修改主题帖
    public int updateThemePost(ThemePost post);

    //获得所有帖子
    public List<ThemePost> queryAllThemePost();

    //查询特定的帖子
    public ThemePost queryThemePostById(int pid);

    //查询一个板块的置顶帖 热帖 精帖  只显示前8条
    public List<ThemePost> queryGoodPostsByTmid(int tmid);

    //查询一个板块第几页的数据
    public List<ThemePost> queryThemePostsByThemePage(ThemePage page);

    //查询当前板块有多少帖子  (没被删除的)
    public int queryCountThemePostsByTmid(int tmid);

    //通过帖子id 查找readthemepost对象
    public ReadThemePost getReadThemePost(int pid);

    //通过帖子id 查找themepost对象
    public ThemePost getThemePost(int pid);

    //通过板块id查找板块对象
    public Theme getTheme(int tmid);

    //主页热帖 4条
    public List<ThemePost> getHotPosts();

    //主页新主题帖 4条
    public List<ThemePost> getNewPosts();

    //主页精华帖
    public List<ThemePost> getGoodPosts();

    //帖子点赞数加一
    public int addPostLike(int pid);

    //查看数加一
    public int addPostVisit(int pid);

    //回帖数加一
    public int addPostReplynum(int pid);

    //查找一个用户的所有帖子
    public List<ThemePost> allUserThemePosts(int uid);

    //删除一个帖子 状态改为1
    public void delThemePost(int pid);

    //帖子加精
    public void setGoodPost(int pid);

    //帖子置顶
    public void setTopPost(int pid);

    //设置为热帖
    public void setHotPost(int pid);

}
