package com.game.dnf.pojo;

/**
 * 徽章
 */
public class Badge {
    private int bid;
    private String badgeurl;
    private String badgeinfo;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBadgeurl() {
        return badgeurl;
    }

    public void setBadgeurl(String badgeurl) {
        this.badgeurl = badgeurl;
    }

    public String getBadgeinfo() {
        return badgeinfo;
    }

    public void setBadgeinfo(String badgeinfo) {
        this.badgeinfo = badgeinfo;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "bid=" + bid +
                ", badgeurl='" + badgeurl + '\'' +
                ", badgeinfo='" + badgeinfo + '\'' +
                '}';
    }
}
