package com.game.dnf.pojo;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;
import java.util.List;

/**
 * 回帖
 */
public class ReplyPost {
    private int rpid;
    /**
     * 回帖人
     */
    private User replyer;
    /**
     * 回帖
     */
    private List<ReplyPost> replyPosts;
    /**
     * 内容
     */
    private String content;
    /**
     * 回帖时间
     */
    private String replytime;
    /**
     * 回帖状态  0 正常  1删帖
     */
    private int replystatus;
    /**
     * 点赞数
     */
    private int replylike;

    @Override
    public String toString() {
        return "ReplyPost{" +
                "rpid=" + rpid +
                ", 回复人=" + replyer.getNickname() +
                ", 回复=" + replyPosts +
                ", 内容='" + content +
                '}';
    }

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public User getReplyer() {
        return replyer;
    }

    public void setReplyer(User replyer) {
        this.replyer = replyer;
    }

    public List<ReplyPost> getReplyPosts() {
        return replyPosts;
    }

    public void setReplyPosts(List<ReplyPost> replyPosts) {
        this.replyPosts = replyPosts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }

    public int getReplystatus() {
        return replystatus;
    }

    public void setReplystatus(int replystatus) {
        this.replystatus = replystatus;
    }

    public int getReplylike() {
        return replylike;
    }

    public void setReplylike(int replylike) {
        this.replylike = replylike;
    }

    public void getSonList(){
        if (this.replyPosts!=null){
            for (int i = 0; i < this.replyPosts.size(); i++) {
                ReplyPost sonPost = this.replyPosts.get(i);
                sonPost.getSonList();
                if (sonPost.getReplyPosts() != null) {
                    this.replyPosts.addAll(sonPost.getReplyPosts());
                    sonPost.setReplyPosts(null);
                }
            }
        }
    }
}
