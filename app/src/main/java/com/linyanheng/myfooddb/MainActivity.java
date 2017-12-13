package com.linyanheng.myfooddb;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    List<Food> data;
    DBAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        if( (data = new FOODDAO(this).getAll()).size()==0)
        {
            new FOODDAO(this).sample(); //寫入db
        }

        data = new FOODDAO(this).getAll();
        adapter = new DBAdapter(data);
        lv.setAdapter(adapter);
    }


    class DBAdapter extends BaseAdapter{
        List<Food> foods;
        LayoutInflater layoutInflater;
        Context context;
        public DBAdapter(List<Food> foods)
        {
            this.foods = foods;
        }

        @Override
        public int getCount() {
            return foods.size();
        }

        @Override
        public Object getItem(int position) {
            return foods.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            context = parent.getContext();
            layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.items,parent,false);
            TextView food = convertView.findViewById(R.id.food);
            TextView cal = convertView.findViewById(R.id.cal);
            food.setText(data.get(position).getFood());
            cal.setText(data.get(position).getCal());

            return convertView;
        }
    }
}
