package io.github.iamvaliyev.multitabmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
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

    OnCategorySelectedListener onCategorySelectedListener;

    Category selectedCategory;
    Object selectedSubCategory;

    boolean isTouching = false;

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

    public void setAdapter(final ParentAdapter adap) {
        categories = adap.getList();
        Log.e("Size2", categories.size() + "");
        this.adapter = adap;
        slCategories.setAdapter(adapter);
        slSubCategories.setAdapter(adapter.getChildAdapter(0));

        selectedCategory = adapter.getItem(0);
        selectedSubCategory = adapter.getChildAdapter(0).getItem(0);

        slCategories.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    isTouching = true;
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    isTouching = false;

                    if (onCategorySelectedListener != null)
                        onCategorySelectedListener.onCategorySelected(categories.get(slCategories.getSelectedItemPosition()));

                    selectedCategory = adapter.getItem(slCategories.getSelectedItemPosition());

                    slSubCategories.setAdapter(adapter.getChildAdapter(slCategories.getSelectedItemPosition()));


                    if (onCategorySelectedListener != null)
                        onCategorySelectedListener.OnSubCategorySelected(categories.get(slCategories.getSelectedItemPosition()).getChildItems().get(slSubCategories.getSelectedItemPosition()));

                    selectedSubCategory = adapter.getChildAdapter(slCategories.getSelectedItemPosition()).getItem(slSubCategories.getSelectedItemPosition());

                }
                return false;
            }
        });

        slSubCategories.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    isTouching = true;
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    isTouching = false;
                    if (onCategorySelectedListener != null)
                        onCategorySelectedListener.OnSubCategorySelected(categories.get(slCategories.getSelectedItemPosition()).getChildItems().get(slSubCategories.getSelectedItemPosition()));

                    selectedSubCategory = adapter.getChildAdapter(slCategories.getSelectedItemPosition()).getItem(slSubCategories.getSelectedItemPosition());
                }
                return false;
            }
        });

//        slCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (onCategorySelectedListener != null)
//                    onCategorySelectedListener.onCategorySelected(categories.get(i));
//
//                selectedCategory = adapter.getItem(i);
//
//                slSubCategories.setAdapter(adapter.getChildAdapter(i));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        slSubCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (onCategorySelectedListener != null)
//                    onCategorySelectedListener.OnSubCategorySelected(categories.get(slCategories.getSelectedItemPosition()).getChildItems().get(i));
//
//                selectedSubCategory = adapter.getChildAdapter(slCategories.getSelectedItemPosition()).getItem(i);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    public OnCategorySelectedListener getOnCategorySelectedListener() {
        return onCategorySelectedListener;
    }

    public void setOnCategorySelectedListener(OnCategorySelectedListener onCategorySelectedListener) {
        this.onCategorySelectedListener = onCategorySelectedListener;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void selectCategory(int position) {
        slCategories.setSelection(position);
    }

    public Object getSelectedSubCategory() {
        return selectedSubCategory;
    }

    public void selectSubCategory(int position) {
        slSubCategories.setSelection(position);
    }

    public int getSelectedCategoryPosition() {
        return slCategories.getSelectedItemPosition();
    }

    public int getSelectedSubCategoryPosition() {
        return slSubCategories.getSelectedItemPosition();
    }

    public interface OnCategorySelectedListener {

        void onCategorySelected(Category category);

        void OnSubCategorySelected(Object object);

    }

}
