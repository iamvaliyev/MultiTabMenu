# MultiTabMenu
MultiTabMenu support for Android 2.1(Eclair)+

##Gradle

```groovy
repositories{
    mavenCentral()
}

dependencies{
    compile 'io.github.iamvaliyev:library:1.0'
}
```
## How to use?
You can also inflate MultiTabMenu from XML:

    <io.github.iamvaliyev.multitabmenu.MultiTabMenu
        android:id="@+id/multiTabMenu"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"/>
        
Java Code
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
