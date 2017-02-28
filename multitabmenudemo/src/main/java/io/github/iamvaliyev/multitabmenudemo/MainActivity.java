package io.github.iamvaliyev.multitabmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.iamvaliyev.multitabmenu.MultiTabMenu;
import io.github.iamvaliyev.multitabmenu.models.Category;
import io.github.iamvaliyev.multitabmenudemo.adapters.CategoryAdapter;
import io.github.iamvaliyev.multitabmenudemo.models.Cat;
import io.github.iamvaliyev.multitabmenudemo.models.SubCat;

public class MainActivity extends AppCompatActivity {

    MultiTabMenu multiTabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiTabMenu = (MultiTabMenu) findViewById(R.id.multiTabMenu);

        List<Cat> list = new ArrayList<>();

        Cat all = new Cat(R.drawable.a, "All");
        Cat menClothes = new Cat(R.drawable.b, "Men Clothes");
        Cat womenClothes = new Cat(R.drawable.c, "Women Clothes");
        Cat womenShoes = new Cat(R.drawable.d, "Women Shoes");
        Cat menShoes = new Cat(R.drawable.e, "Men Shoes");

        all.add(new SubCat("Adidas"));
        all.add(new SubCat("Nike"));
        all.add(new SubCat("Zara"));
        all.add(new SubCat("LC Waikiki"));
        all.add(new SubCat("Pull and Bear"));
        all.add(new SubCat("United Colors of Benetton"));

        menClothes.add(new SubCat("Zara"));
        menClothes.add(new SubCat("LC Waikiki"));
        menClothes.add(new SubCat("Pull and Bear"));

        womenClothes.add(new SubCat("MANGO"));
        womenClothes.add(new SubCat("LC Waikiki"));
        womenClothes.add(new SubCat("Pull and Bear"));
        womenClothes.add(new SubCat("Charlotte Russe"));

        womenShoes.add(new SubCat("Adidas"));
        womenShoes.add(new SubCat("Nike"));
        womenShoes.add(new SubCat("Charlotte Russe"));

        menShoes.add(new SubCat("Adidas"));
        menShoes.add(new SubCat("Nike"));

        list.add(all);
        list.add(menClothes);
        list.add(womenClothes);
        list.add(womenShoes);
        list.add(menShoes);

        Log.e("Size", list.size() + "");

        multiTabMenu.setAdapter(new CategoryAdapter(getApplicationContext(), list));

        multiTabMenu.setOnCategorySelectedListener(new MultiTabMenu.OnCategorySelectedListener() {
            @Override
            public void onCategorySelected(Category category) {
                Toast.makeText(getApplicationContext(), ((Cat) category).getTitle() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnSubCategorySelected(Object object) {
                Toast.makeText(getApplicationContext(), ((SubCat) object).getTitle() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
