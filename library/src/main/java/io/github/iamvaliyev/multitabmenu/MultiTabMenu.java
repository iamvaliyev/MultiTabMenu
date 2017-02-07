package io.github.iamvaliyev.multitabmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import io.github.iamvaliyev.multitabmenu.adapters.ParentAdapter;
import io.github.iamvaliyev.multitabmenu.coverflow.FancyCoverFlow;
import io.github.iamvaliyev.multitabmenu.models.Category;
import io.github.iamvaliyev.multitabmenu.widgets.TriangleShapeView;

/**
 * Created by Emil Valiyev on 12/23/16.
 */

public class MultiTabMenu extends LinearLayout {

    FancyCoverFlow slCategories;
    FancyCoverFlow slSubCategories;
    TriangleShapeView triangle;

    LinearLayout ln;
    FrameLayout fl;

    List<Category> categories = new ArrayList<>();

    private int categoriesBackground;
    private int subCategoriesBackground;
    private int triangleBackground;

    ParentAdapter adapter;

    public MultiTabMenu(Context context) {
        super(context);
        initView();
        applyXmlAttributes(null, 0);
    }

    public MultiTabMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        applyXmlAttributes(attrs, 0);
    }

    public MultiTabMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        applyXmlAttributes(attrs, defStyleAttr);
    }

    public void initView() {
        View.inflate(getContext(), R.layout.layout_menu, this);
        slCategories = (FancyCoverFlow) findViewById(R.id.slCategories);
        slSubCategories = (FancyCoverFlow) findViewById(R.id.slSubCategories);
        ln = (LinearLayout) findViewById(R.id.ln);
        fl = (FrameLayout) findViewById(R.id.fl);
        triangle = (TriangleShapeView) findViewById(R.id.triangle);
    }

    private void applyXmlAttributes(AttributeSet attrs, int defStyle) {
        initStateMultiTabMenu();
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MultiTabMenu, defStyle, 0);
            this.categoriesBackground = a.getColor(R.styleable.MultiTabMenu_categoriesBackground, categoriesBackground);
            this.subCategoriesBackground = a.getColor(R.styleable.MultiTabMenu_subCategoriesBackground, subCategoriesBackground);
            this.triangleBackground = a.getColor(R.styleable.MultiTabMenu_triangleBackground, triangleBackground);
            setCategoriesBackground(categoriesBackground);
            setSubCategoriesBackground(subCategoriesBackground);
            setTriangleBackground(triangleBackground);
            a.recycle();
        }
    }

    public void setCategoriesBackground(int color) {
        this.categoriesBackground = color;
        ln.setBackgroundColor(categoriesBackground);
        invalidate();
    }

    public void setSubCategoriesBackground(int color) {
        this.subCategoriesBackground = color;
        fl.setBackgroundColor(subCategoriesBackground);
        invalidate();
    }

    public void setTriangleBackground(int triangleBackground) {
        this.triangleBackground = triangleBackground;
        triangle.setColorCode(triangleBackground);
        triangle.invalidate();
    }

    public void initStateMultiTabMenu() {
        categoriesBackground = ContextCompat.getColor(getContext(), R.color.categoriesBackground);
        subCategoriesBackground = ContextCompat.getColor(getContext(), R.color.subCategoriesBackground);
    }

    public void setupSubCategories(ParentAdapter adap) {
        categories = adap.getList();
        Log.e("Size2", categories.size() + "");
        this.adapter = adap;
        slCategories.setAdapter(adapter);

        slCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                slSubCategories.setAdapter(adapter.getChildAdapter(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

//    public void setupSubCategories(List<Category> list) {
//        categories = list;
//        Log.e("Size2", categories.size() + "");
//
//        if (adapter != null) {
//            adapter.setList(categories);
//
//            slCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                    slSubCategories.setAdapter(adapter.getChildAdapter(i));
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> adapterView) {
//
//                }
//            });
//        }
//    }
}
