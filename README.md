# MultiTabMenu
MultiTabMenu support for Android 2.1(Eclair)+

![Preview](https://cloud.githubusercontent.com/assets/7686591/22694543/1d2ed4da-ed61-11e6-9a28-8a89a390e5f2.gif)

##Gradle

```groovy
repositories{
    maven { url 'https://jitpack.io' }
}

dependencies{
    compile 'com.github.iamvaliyev:MultiTabMenu:1.0.0'
}
```
## How to use?
You can also inflate MultiTabMenu from XML:

    <io.github.iamvaliyev.multitabmenu.MultiTabMenu
        android:id="@+id/multiTabMenu"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"/>
        
## Java Code

    multiTabMenu = (MultiTabMenu) findViewById(R.id.multiTabMenu);
    
Setup Adapter

    multiTabMenu.setupSubCategories(new CategoryAdapter(getApplicationContext(), list));

Adapter:
    
    public class CategoryAdapter extends ParentAdapter {

        List<Cat> list;

        public CategoryAdapter(Context context, List<Cat> list) {
            super(context, list);
            .......
        }

        @Override
        public View getSectionView(int position, View view, ViewGroup parent) {
            .......
        }

        @Override
        public View getChildView(int position, int childPosition, View view, ViewGroup parent) {
            .......
        }
    }

Model with CategoryWrapper:
    
    public class YourCategoryModel implements Category<YourSubCategoryModel> {

        String title;
        List<YourSubCategoryModel> list = new ArrayList<>();

        public Cat(String title) {
            this.title = title;
        }

        @Override
        public List getChildItems() {
            return list;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<YourSubCategoryModel> getList() {
            return list;
        }

        public void setList(List<YourSubCategoryModel> list) {
            this.list = list;
        }

        public void add(SubCat subCat){
            list.add(subCat);
        }
    }

        
## Attributes
        app:categoriesBackground="@color/colorPrimaryDark"
        app:subCategoriesBackground="@color/colorPrimary"
        app:triangleBackground="@color/colorAccent"

##Thanks
*   [FancyCoverFlow](https://github.com/davidschreiber/FancyCoverFlow)

License
-------

    Copyright 2016 Emil Valiyev

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
