package io.github.iamvaliyev.multitabmenudemo.models;

import java.util.ArrayList;
import java.util.List;

import io.github.iamvaliyev.multitabmenu.models.Category;

public class Cat implements Category<SubCat> {

    int icon;
    String title;

    List<SubCat> list = new ArrayList<>();

    public Cat(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public Cat(List<SubCat> list) {
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

    public List<SubCat> getList() {
        return list;
    }

    public void setList(List<SubCat> list) {
        this.list = list;
    }

    public void add(SubCat subCat){
        list.add(subCat);
    }
}
