package com.game.dnf.pojo;

/**
 * 主题区
 */
public class Theme {

    private int tmid;
    private String tmname;

    @Override
    public String toString() {
        return "Theme{" +
                "tmid=" + tmid +
                ", tmname='" + tmname + '\'' +
                '}';
    }

    public int getTmid() {
        return tmid;
    }

    public void setTmid(int tmid) {
        this.tmid = tmid;
    }

    public String getTmname() {
        return tmname;
    }

    public void setTmname(String tmname) {
        this.tmname = tmname;
    }
}
