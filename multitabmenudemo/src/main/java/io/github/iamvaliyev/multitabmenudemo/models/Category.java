package io.github.iamvaliyev.multitabmenudemo.models;

import java.util.ArrayList;
import java.util.List;

public class Category implements io.github.iamvaliyev.multitabmenu.models.Category<SubCategory> {

    int icon;
    String title;

    List<SubCategory> list = new ArrayList<>();

    public Category(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public Category(List<SubCategory> list) {
        this.list = list;
    }

    @Override
    public List getChildItems() {
        return list;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubCategory> getList() {
        return list;
    }

    public void setList(List<SubCategory> list) {
        this.list = list;
    }

    public void add(SubCategory subCategory){
        list.add(subCategory);
    }
}
