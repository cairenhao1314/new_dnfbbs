package com.game.dnf.pojo;

/**
 * 板块 分页 对象
 */
public class ThemePage {
    /**
     * 当前的板块id
     */
    private int tmid;
    /**
     * 当前页
     */
    private int curr;
    /**
     * 显示数量
     */
    private int limit;



    /**
     * 从几开始
     */
    private int firstindex;
    /**
     * 到几结束
     */
    private int lastindex;

    public ThemePage() {
    }

    public ThemePage(int tmid, int curr, int limit) {
        this.tmid = tmid;
        this.curr = curr;
        this.limit = limit;
        this.firstindex = (curr-1)*limit;
        this.lastindex = curr*limit;
    }

    @Override
    public String toString() {
        return "ThemePage{" +
                "tmid=" + tmid +
                ", curr=" + curr +
                ", limit=" + limit +
                ", firstindex=" + firstindex +
                ", lastindex=" + lastindex +
                '}';
    }

    public int getTmid() {
        return tmid;
    }

    public void setTmid(int tmid) {
        this.tmid = tmid;
    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
        this.firstindex = (curr-1)*this.limit;
        this.lastindex = curr*this.limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
        this.firstindex = (this.curr-1)*limit;
        this.lastindex = this.curr*limit;
    }

    public int getFirstindex() {
        return firstindex;
    }

    public void setFirstindex(int firstindex) {
        this.firstindex = firstindex;
    }

    public int getLastindex() {
        return lastindex;
    }

    public void setLastindex(int lastindex) {
        this.lastindex = lastindex;
    }
}
