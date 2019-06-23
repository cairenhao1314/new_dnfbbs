package com.game.dnf.pojo;

import java.util.List;

public class AddReply {
    private int rpid;
    /**
     * 回帖人
     */
    private int uid;
    /***
     * 主题帖id
     */
    private int pid;
    /**
     * 回复回复贴id
     */
    private int to_rpid;
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



    public AddReply() {
    }

    public AddReply(int uid, int pid, int to_rpid, String content) {
        this.uid = uid;
        this.pid = pid;
        this.to_rpid = to_rpid;
        this.content = content;
    }

    public AddReply(int rpid, int uid, int pid, int to_rpid, String content) {
        this.rpid = rpid;
        this.uid = uid;
        this.pid = pid;
        this.to_rpid = to_rpid;
        this.content = content;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRpid() {
        return rpid;
    }

    public void setRpid(int rpid) {
        this.rpid = rpid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "AddReply{" +
                "rpid=" + rpid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", to_rpid=" + to_rpid +
                ", content='" + content + '\'' +
                ", replytime='" + replytime + '\'' +
                ", replystatus=" + replystatus +
                ", replylike=" + replylike +
                '}';
    }

    public int getTo_rpid() {
        return to_rpid;
    }

    public void setTo_rpid(int to_rpid) {
        this.to_rpid = to_rpid;
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
}
