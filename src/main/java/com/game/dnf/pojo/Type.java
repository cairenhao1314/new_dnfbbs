package com.game.dnf.pojo;

/**
 * 帖子类型
 */
public class Type {
    private int tyid;
    private String tname;

    public int getTyid() {
        return tyid;
    }

    public void setTyid(int tyid) {
        this.tyid = tyid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tyid=" + tyid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
