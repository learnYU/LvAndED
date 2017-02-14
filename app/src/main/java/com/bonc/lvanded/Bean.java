package com.bonc.lvanded;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kongdy on 2017/2/11.
 */
public class Bean implements Serializable{
    private String group;

    private boolean isWrite;
    private List<ChildBean> list;

    public Bean(String group, List<ChildBean> list) {
        this.group = group;
        this.list = list;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<ChildBean> getList() {
        return list;
    }

    public void setList(List<ChildBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "group='" + group + '\'' +
                ", list=" + list +
                '}';
    }
}
