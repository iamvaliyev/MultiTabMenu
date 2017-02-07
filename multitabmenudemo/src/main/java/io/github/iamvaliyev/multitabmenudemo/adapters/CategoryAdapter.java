
package io.github.iamvaliyev.multitabmenudemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.github.iamvaliyev.multitabmenu.adapters.ParentAdapter;
import io.github.iamvaliyev.multitabmenudemo.R;
import io.github.iamvaliyev.multitabmenudemo.models.Category;

public class CategoryAdapter extends ParentAdapter {

    List<Category> list;

    public CategoryAdapter(Context context, List<Category> list) {
        super(context, list);
        this.list = list;
    }

    @Override
    public View getSectionView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false);
        }

        ImageView imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);

        imgIcon.setImageResource(list.get(position).getIcon());
        txtTitle.setText(list.get(position).getTitle());
        return view;
    }

    @Override
    public View getChildView(int position, int childPosition, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_subcategory, parent, false);
        }

        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtTitle.setText(list.get(position).getList().get(childPosition).getTitle());

        return view;

    }
}
