package com.game.dnf.pojo;

import java.util.List;

/**
 * 用户
 */
public class User {
    private int uid;
    private String nickname;

    public User() {
    }

    private String pwd;

    public User(int uid) {
        this.uid = uid;
    }

    private String phone;
    private String email;
    /**
     * 状态
     * （封禁2 正常1 未激活 -1）
     */
    private int ustatus;
    /**
     * 角色
     * （普通用户  1 管理员  2 版主    3）
     */
    private int role;
    private String headphoto;
    private String registertime;
    /**
     * 个性签名
     */
    private String signature;

    /**
     * 用户的徽章
     */
    private List<Badge> badges;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ustatus=" + ustatus +
                ", role=" + role +
                ", headphoto='" + headphoto + '\'' +
                ", registertime='" + registertime + '\'' +
                ", signature='" + signature + '\'' +
                ", badges=" + badges +
                '}';
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getHeadphoto() {
        return headphoto;
    }

    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
