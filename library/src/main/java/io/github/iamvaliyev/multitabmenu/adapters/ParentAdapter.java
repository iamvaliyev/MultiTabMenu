/*
 * Copyright 2013 David Schreiber
 *           2013 John Paul Nalog
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.github.iamvaliyev.multitabmenu.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import io.github.iamvaliyev.multitabmenu.coverflow.FancyCoverFlowAdapter;
import io.github.iamvaliyev.multitabmenu.models.Category;

public abstract class ParentAdapter<S extends Category<C>, C> extends FancyCoverFlowAdapter {

    List<S> list;
    public Context mContext;

    ChildAdapter adapter;

    public ParentAdapter(Context context, List<S> list) {
        this.mContext = context;
        this.list = list;
        adapter = new ChildAdapter(0);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Category getItem(int i) {
        return list.get(i);
    }

    public List<C> getChildItems(int position) {
        return list.get(position).getChildItems();
    }

    public ChildAdapter getChildAdapter(int position) {
        adapter.setPosition(position);
        return adapter;
    }

    public List<S> getList() {
        return list;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return getSectionView(position, convertView, parent);
//    }

    @Override
    public View getCoverFlowItem(int i, View view, ViewGroup viewGroup) {
        Log.e("AdapterParent", i + "");
        return getSectionView(i, view, viewGroup);
    }

    public abstract View getSectionView(int position, View view, ViewGroup parent);

    public abstract View getChildView(int position, int childPosition, View view, ViewGroup parent);

    public class ChildAdapter extends FancyCoverFlowAdapter {

        int position;

        public ChildAdapter(int position) {
            this.position = position;
        }

//        @Override
//        public View getView(int childPosition, View convertView, ViewGroup parent) {
//            return getChildView(position, childPosition, convertView, parent);
//        }

                @Override
        public View getCoverFlowItem(int childPosition, View view, ViewGroup parent) {
            Log.e("AdapterParentChild", position + "");
            return getChildView(position, childPosition, view, parent);
        }

        @Override
        public int getCount() {
            return getChildItems(position).size();
        }

        @Override
        public C getItem(int i) {
            return getChildItems(position).get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public void setList(List<S> list) {
        Log.e("Size4", list.size() + "");
        this.list = list;
        notifyDataSetChanged();
    }

}
