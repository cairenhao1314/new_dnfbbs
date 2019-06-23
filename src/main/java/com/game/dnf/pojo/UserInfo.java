package com.game.dnf.pojo;

/**
 * 用户详情
 */
public class UserInfo {

    private int uifid;
    private String realname;
    private String IDcard;
    /**
     * 擅长职业
     */
    private String profession;
    /**
     * 安全问题
     */
    private String safeissue;
    private String answer;

    @Override
    public String toString() {
        return "UserInfo{" +
                "uifid=" + uifid +
                ", realname='" + realname + '\'' +
                ", IDcard='" + IDcard + '\'' +
                ", profession='" + profession + '\'' +
                ", safeissue='" + safeissue + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public int getUifid() {
        return uifid;
    }

    public void setUifid(int uifid) {
        this.uifid = uifid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSafeissue() {
        return safeissue;
    }

    public void setSafeissue(String safeissue) {
        this.safeissue = safeissue;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
