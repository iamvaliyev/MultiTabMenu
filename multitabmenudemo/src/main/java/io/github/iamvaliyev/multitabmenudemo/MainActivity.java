package io.github.iamvaliyev.multitabmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.github.iamvaliyev.multitabmenu.MultiTabMenu;
import io.github.iamvaliyev.multitabmenudemo.adapters.CategoryAdapter;
import io.github.iamvaliyev.multitabmenudemo.models.Category;
import io.github.iamvaliyev.multitabmenudemo.models.SubCategory;

public class MainActivity extends AppCompatActivity {

    MultiTabMenu multiTabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiTabMenu = (MultiTabMenu) findViewById(R.id.multiTabMenu);

        List<Category> list = new ArrayList<>();

        Category all = new Category(R.drawable.a, "All");
        Category menClothes = new Category(R.drawable.b, "Men Clothes");
        Category womenClothes = new Category(R.drawable.c, "Women Clothes");
        Category womenShoes = new Category(R.drawable.d, "Women Shoes");
        Category menShoes = new Category(R.drawable.e, "Men Shoes");

        all.add(new SubCategory("Adidas"));
        all.add(new SubCategory("Nike"));
        all.add(new SubCategory("Zara"));
        all.add(new SubCategory("LC Waikiki"));
        all.add(new SubCategory("Pull and Bear"));
        all.add(new SubCategory("United Colors of Benetton"));

        menClothes.add(new SubCategory("Zara"));
        menClothes.add(new SubCategory("LC Waikiki"));
        menClothes.add(new SubCategory("Pull and Bear"));

        womenClothes.add(new SubCategory("MANGO"));
        womenClothes.add(new SubCategory("LC Waikiki"));
        womenClothes.add(new SubCategory("Pull and Bear"));
        womenClothes.add(new SubCategory("Charlotte Russe"));

        womenShoes.add(new SubCategory("Adidas"));
        womenShoes.add(new SubCategory("Nike"));
        womenShoes.add(new SubCategory("Charlotte Russe"));

        menShoes.add(new SubCategory("Adidas"));
        menShoes.add(new SubCategory("Nike"));

        list.add(all);
        list.add(menClothes);
        list.add(womenClothes);
        list.add(womenShoes);
        list.add(menShoes);

        Log.e("Size", list.size() + "");

        multiTabMenu.setupSubCategories(new CategoryAdapter(getApplicationContext(), list));
    }
}
