package com.example.sujith.listview_withimages;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class page1 extends AppCompatActivity {

    ListView listp;
    ImageView imgp;
    TextView texp;

    ArrayList<String> arr=new ArrayList<>();

    int[] imag={R.mipmap.bro,R.mipmap.pho};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        listp=findViewById(R.id.list);

        arr.add("Browser");
        arr.add("phone");

        adapt ad=new adapt();
        listp.setAdapter(ad);

        listp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position==0)
                {
                    Toast.makeText(page1.this, "Browser", Toast.LENGTH_SHORT).show();
                }
                else if (position==1)
                {
                    Toast.makeText(page1.this, "Phone", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    class adapt extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return arr.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflat=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflat.inflate(R.layout.cust,null);
            texp=convertView.findViewById(R.id.tex);
            imgp=convertView.findViewById(R.id.img);
            imgp.setImageResource(imag[position]);
            texp.setText(arr.get(position));
            return convertView;
        }
    }
}
