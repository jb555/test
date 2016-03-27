package com.example.brazz.jiajian11;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.brazz.jiajian11.view.FirstPage_fragment;
import com.example.brazz.jiajian11.view.Kebiao_fragment;
import com.example.brazz.jiajian11.view.Other_fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FirstPage_fragment firstPage_fragment;
    private Kebiao_fragment kebiao_fragment;
    private Other_fragment other_fragment;


    //tabbar内容
    //  private TextView textView1,textView2,textView3;
    private Button btn1,btn2,btn3;

    private FrameLayout frameLayout;

    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetValue();
    }

    public void GetValue()
    {
        frameLayout = (FrameLayout)findViewById(R.id.fram);

        view = findViewById(R.id.include);

        firstPage_fragment = new FirstPage_fragment();
        kebiao_fragment = new Kebiao_fragment();
        other_fragment = new Other_fragment();


        //tabbar内容初始化
        btn1 = (Button)view.findViewById(R.id.button);
        btn2 = (Button)view.findViewById(R.id.button2);
        btn3 = (Button)view.findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch(v.getId())
        {
            case R.id.button:
                btn1.setTextSize(16);
                btn2.setTextSize(12);
                btn3.setTextSize(12);

                ft.replace(R.id.fram, firstPage_fragment);
                ft.commit();
                break;
            case R.id.button2:
                btn1.setTextSize(12);
                btn2.setTextSize(16);
                btn3.setTextSize(12);

                ft.replace(R.id.fram, kebiao_fragment);
                ft.commit();
                break;
            case R.id.button3:
                btn1.setTextSize(12);
                btn2.setTextSize(12);
                btn3.setTextSize(16);

                ft.replace(R.id.fram, other_fragment);
                ft.commit();
                break;
        }
    }
}
