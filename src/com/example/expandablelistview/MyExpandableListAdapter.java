package com.example.expandablelistview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    
    private int[] logos = new int[] {
            R.drawable.p,
            R.drawable.t,
            R.drawable.z,
    };
    
    private String[] race = new String[] {"Protoss", "Terran", "Zerg"};

    private String[][] army = new String[][] {
            {"A", "B", "C", "D"},
            {"E", "F", "G", "H"},
            {"I", "J", "K"},
    };

    public MyExpandableListAdapter(Context context) {
        this.context = context;
    }
    
    @Override
    public int getGroupCount() {
        return race.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return army[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return race[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return army[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(context);
        ImageView logo = new ImageView(context);
        logo.setImageResource(logos[groupPosition]);
        ll.addView(logo);
        TextView textView = getTextView();
        textView.setText(getGroup(groupPosition).toString());
        ll.addView(textView);
        return ll;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = getTextView();
        textView.setText(getChild(groupPosition, childPosition).toString());
        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    
    private TextView getTextView() {
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(context);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);

        return textView;
    }

}
