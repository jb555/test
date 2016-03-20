package com.example.brazz.jiajian00;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by BrazZ on 2016/3/11.
 */
public class Topbar extends RelativeLayout {
    private float Left_text_size,Rigth_text_size,Title_size;
    private String Title,Left_text,Right_text;

  //  private Button leftBtn,rightBtn;
    private TextView title,leftBtn,rightBtn;

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);


        GetAttrsValue(context, attrs);

        leftBtn = new TextView(context);
        rightBtn = new TextView(context);
        title =  new TextView(context);

        LayoutParams leftparms = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftparms.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        leftBtn.setLayoutParams(leftparms);
        leftBtn.setText(Left_text);
        leftBtn.setGravity(Gravity.CENTER);
        leftBtn.setTextSize(10);//有问题
        leftBtn.setTextColor(Color.WHITE);
       // leftBtn.setAlpha(0.4f);

        LayoutParams rigthparms = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rigthparms.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightBtn.setLayoutParams(rigthparms);
        rightBtn.setText(Right_text);
        rightBtn.setGravity(Gravity.CENTER);
        rightBtn.setTextSize(10);//有问题
        rightBtn.setTextColor(Color.WHITE);
      //  rightBtn.setAlpha(0.4f);


        LayoutParams titleparms = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleparms.addRule(RelativeLayout.CENTER_IN_PARENT);
        title.setLayoutParams(titleparms);
        title.setText(Title);
        title.setTextSize(16);//有问题
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
      //  title.setAlpha(0.4f);


        addView(leftBtn);
        addView(title);
        addView(rightBtn);
    }
    private void GetAttrsValue(Context context, AttributeSet attrs)
    {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.topbar);

        Title = ta.getString(R.styleable.topbar_titile_text);
        Title_size = ta.getDimension(R.styleable.topbar_title_size, 0);

        Left_text = ta.getString(R.styleable.topbar_left_text);
        Left_text_size = ta.getDimension(R.styleable.topbar_left_text_size, 0);

        Right_text = ta.getString(R.styleable.topbar_right_text);
        Rigth_text_size = ta.getDimension(R.styleable.topbar_right_text_size, 0);

        ta.recycle();
    }
}
