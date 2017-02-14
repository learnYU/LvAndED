package com.bonc.lvanded;

/**
 * Created by kongdy on 2017/2/11.
 */
public class ChildBean {
    private String content;
    private String title ;

    public ChildBean(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
