package com.bonc.lvanded;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.expandableListView) ExpandableListView listView;
    private List<Bean> glist ;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        glist = new ArrayList<>();

        for (int i = 0; i<20 ;i++){
            List<ChildBean> clist = new ArrayList<>();
            clist.add(new ChildBean("","a"));

            glist.add(new Bean("a"+i,clist));
        }
        Log.d("aaa",glist.toString());
        listView.setAdapter(new Adapter());

    }


    class Adapter extends BaseExpandableListAdapter{


        @Override
        public int getGroupCount() {
            return glist.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return glist.get(i).getList().size();
        }

        @Override
        public Object getGroup(int i) {
            return glist.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return glist.get(i).getList().get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.group_item, null);
            }

            TextView groupTv = (TextView) view.findViewById(R.id.group_title);
            Bean bean = glist.get(i);

            groupTv.setText(bean.getGroup());
            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.child_item, viewGroup, false);
            }

            TextView childTv = (TextView) view.findViewById(R.id.child_title);
            EditText editText = (EditText) view.findViewById(R.id.editText);
            List<ChildBean> clist = glist.get(i).getList();
            Bean bean  = glist.get(i);

            final ChildBean childbean = bean.getList().get(i1);
            childTv.setText(childbean.getTitle());

            editText.setText(childbean.getContent());

            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    Log.d("onEditorAction",textView.getText().toString());

                    childbean.setContent(textView.getText().toString());
                    return true;
                }
            });

            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }

    }



}
