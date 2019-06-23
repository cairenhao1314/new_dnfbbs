package com.game.dnf.pojo;

/**
 * 主题帖
 */
public class ThemePost {

    private int pid;
    private User author;
    private Theme theme;
    private Type type;
    private String title;
    private String content;
    private String postingtime;
    /**
     * 帖子状态
     * （0正常 1删帖）
     */
    private int pstatus;
    /**
     * 帖子情况
     * 0普通帖子
     * 1精品帖子
     * 2置顶帖子
     * 3热帖
     */
    private int pcase;
    /**
     * 点赞数
     */
    private int plike;
    /**
     * 访问数
     */
    private int visits;
    /**
     * 回复量
     */
    private int replynum;

    /**
     * 召唤策划
     */
    private int callnum;

    @Override
    public String toString() {
        return "ThemePost{" +
                "pid=" + pid +
                ", author=" + author.getNickname() +
                ", title='" + title + '\'' +
                '}';
    }

    public int getCallnum() {
        return callnum;
    }

    public void setCallnum(int callnum) {
        this.callnum = callnum;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostingtime() {
        return postingtime;
    }

    public void setPostingtime(String postingtime) {
        this.postingtime = postingtime;
    }

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }

    public int getPcase() {
        return pcase;
    }

    public void setPcase(int pcase) {
        this.pcase = pcase;
    }

    public int getPlike() {
        return plike;
    }

    public void setPlike(int plike) {
        this.plike = plike;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getReplynum() {
        return replynum;
    }

    public void setReplynum(int replynum) {
        this.replynum = replynum;
    }
}
