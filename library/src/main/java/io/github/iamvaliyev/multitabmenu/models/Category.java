package io.github.iamvaliyev.multitabmenu.models;

import java.util.List;

public interface Category<C> {
    List<C> getChildItems();
}
