package com.game.dnf.pojo;

/**
 * 财产
 */
public class UserProperty {
    private int uid;

    //金币
    private int goldcoin;
    //经验值
    private int EXP;
    //魅力值
    private int charm;
    //粉丝币
    private int fanscoin;
    //代币券
    private int coupon;

    public UserProperty(int uid, int goldcoin) {
        this.uid = uid;
        this.goldcoin = goldcoin;
    }

    public UserProperty() {
    }

    @Override
    public String toString() {
        return "UserProperty{" +
                "uid=" + uid +
                ", goldcoin=" + goldcoin +
                ", EXP=" + EXP +
                ", charm=" + charm +
                ", fanscoin=" + fanscoin +
                ", coupon=" + coupon +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGoldcoin() {
        return goldcoin;
    }

    public void setGoldcoin(int goldcoin) {
        this.goldcoin = goldcoin;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public int getFanscoin() {
        return fanscoin;
    }

    public void setFanscoin(int fanscoin) {
        this.fanscoin = fanscoin;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }
}
