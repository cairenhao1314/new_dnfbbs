package com.game.dnf.pojo;

import java.util.List;

/**
 * 用于展示主题帖的实体类
 */
public class ReadThemePost {
    /**
     * 主题帖
     */
    private ThemePost themePost;
    /**
     * 回复帖
     */
    private List<ReplyPost> replyPosts;

    public ThemePost getThemePost() {
        return themePost;
    }

    @Override
    public String toString() {
        return "ReadThemePost{" +
                "themePost=" + themePost +
                ", replyPosts=" + replyPosts +
                '}';
    }

    public void setThemePost(ThemePost themePost) {
        this.themePost = themePost;
    }

    public List<ReplyPost> getReplyPosts() {
        return replyPosts;
    }

    public void setReplyPosts(List<ReplyPost> replyPosts) {
        this.replyPosts = replyPosts;
    }
}
