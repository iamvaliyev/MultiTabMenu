package io.github.iamvaliyev.multitabmenu;

import io.github.iamvaliyev.multitabmenu.models.Category;

/**
 * Created by Emil Valiyev on 12/23/16.
 */

public class CategoryWrapper<S extends Category<C>, C> {

    private boolean sectionItem;
    private S section;
    private C child;
    private int sectionPosition;
    private int childPosition;

    /**
     * Constructor to wrap a section object of type {@link S}.
     *
     * @param section The parent object to wrap
     */
    public CategoryWrapper(S section, int sectionPosition) {
        this.sectionItem = true;
        this.section = section;
        this.sectionPosition = sectionPosition;
        this.childPosition = -1;
    }

    /**
     * Constructor to wrap a child object of type {@link C}.
     *
     * @param child The child object to wrap
     */
    public CategoryWrapper(C child, int sectionPosition, int childPosition) {
        this.child = child;
        this.sectionPosition = sectionPosition;
        this.sectionItem = false;
        this.childPosition = childPosition;
    }

    public boolean isSection() {
        return sectionItem;
    }

    public S getSection() {
        return section;
    }

    public C getChild() {
        return child;
    }

    public int getSectionPosition() {
        return sectionPosition;
    }

    public int getChildPosition() {
        if (childPosition == -1)
            throw new IllegalAccessError("This is not child");
        return childPosition;
    }

}
