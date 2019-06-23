package com.game.dnf.pojo;

import java.util.Comparator;

//回复贴的外部比较器
public class TimeComparator implements Comparator<ReplyPost> {
    @Override
    public int compare(ReplyPost p1, ReplyPost p2) {

        return p1.getReplytime().compareTo(p2.getReplytime());
    }
}
