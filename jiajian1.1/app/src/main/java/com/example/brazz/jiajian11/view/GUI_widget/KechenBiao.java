package com.example.brazz.jiajian11.view.GUI_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.example.brazz.jiajian11.R;

/**
 * Created by BrazZ on 2016/2/28.
 */
public class KechenBiao extends FrameLayout {

    final float Section_Weight = 1.5f;//节次的权值
    final float Lesson_Weight =0.2f;//课程的权值
    final float TextSize = 12;//字大小
    final float LessonSize = 8;
    final BootstrapBrand bootstrapBrand[] = {DefaultBootstrapBrand.DANGER, DefaultBootstrapBrand.INFO, DefaultBootstrapBrand.PRIMARY, DefaultBootstrapBrand.REGULAR, DefaultBootstrapBrand.SECONDARY, DefaultBootstrapBrand.SUCCESS, DefaultBootstrapBrand.WARNING};
    private Context conText;

    //总体的控件

    private LinearLayout TotalLayout;
    private GridView gridView;
    private KeBiaoMssg KebiaoMsg[][];

    //定义第一行的控件
    private LinearLayout TopLayout;
    private LinearLayout Week_Layout;
    private BootstrapButton Monthbtn;
    private BootstrapButton WeekButton[];

    //定义底部的控件
    private LinearLayout SectionLayout;//定义节次列
    private BootstrapButton SectionButton[];
    private ScrollView scrollView; //用户滑动
    private LinearLayout BottmLayout; // 下面的总体layout
    private RelativeLayout LessonLayout[];
    private LinearLayout LessonsLayout; // 课程的layout

    //attrs属性
    private float LineHigh;


    //一些比例
    final int Top_Month_rate = 14;
    final int Top_Week_rate  = 1;
    final int Bottom_Section_rate = Top_Month_rate;
    final int Botton_Lesson_rate = Top_Week_rate;

    private int ScreenWidth,Section_Width,Lesson_Width;


    public KechenBiao(Context context, AttributeSet attrs) {
        super(context, attrs);
        conText = context;


     // setBackgroundResource(R.drawable.kebiao);
      //  GetAttrs_Value( context, attrs);
        GetScreenSize();


        gridView = new GridView(context);
        gridView.setNumColumns(7);
        gridView.setHorizontalSpacing(0);
        gridView.setVerticalSpacing(0);
        gridView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Botton_Lesson_rate));
        KebiaoMsg = new KeBiaoMssg[10][7];

        WeekButton = new BootstrapButton[7];
        SectionButton = new BootstrapButton[13];
        LessonLayout = new RelativeLayout[7];

        TotalLayout = new LinearLayout(context);
        TotalLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TotalLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(TotalLayout);


        SetTopBar(context);
        SetSectionBar(context);
        SetBottmBar(context);
        TotalLayout.addView(TopLayout);
        scrollView.addView(BottmLayout);
        TotalLayout.addView(scrollView);


    }
    private void GetScreenSize()
    {
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        ScreenWidth = wm.getDefaultDisplay().getWidth();

        Section_Width = (ScreenWidth / 15);
        Lesson_Width = Section_Width * 2;

    }


    public void SetCourseMessage(KeBiaoMssg keBiaoMssg)//设置课程的BTN
    {
        MarginLayoutParams mp = new MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,keBiaoMssg.Jieshu * Lesson_Width);
        mp.setMargins(0, (keBiaoMssg.Section - 1) * Lesson_Width, 0, 0);
        RelativeLayout.LayoutParams rp = new RelativeLayout.LayoutParams(mp);

        BootstrapButton btn = new BootstrapButton(conText);
        btn.setBootstrapSize(0.8f);
        btn.setLayoutParams(rp);
        btn.setRounded(true);


        btn.setText(keBiaoMssg.CourseName+"@"+keBiaoMssg.Place);
        btn.setBootstrapBrand(bootstrapBrand[(int)(Math.random()*7)]);
        LessonLayout[keBiaoMssg.WhichDay-1].addView(btn);
    }

    private void SetTopBar(Context context)
    {
        TopLayout = new LinearLayout(context);
        TopLayout.setOrientation(LinearLayout.HORIZONTAL);
        TopLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        Week_Layout = new LinearLayout(context);
        Week_Layout.setOrientation(LinearLayout.HORIZONTAL);
        Week_Layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Top_Week_rate));

        Monthbtn = new BootstrapButton(context);
        Monthbtn.setText("2月");
        Monthbtn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Top_Month_rate));
        Monthbtn.setBootstrapSize(0.6f);
        Monthbtn.setShowOutline(true);


        TopLayout.addView(Monthbtn);
        TopLayout.addView(Week_Layout);

        for(int i=0;i<7;i++)
        {
            WeekButton[i] = new BootstrapButton(context);
            WeekButton[i].setText("周" + (i + 1));
            WeekButton[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Top_Week_rate));
            WeekButton[i].setTextSize(TypedValue.COMPLEX_UNIT_DIP, TextSize);
            WeekButton[i].setBootstrapSize(0.6f);
            Week_Layout.addView(WeekButton[i]);

            WeekButton[i].setShowOutline(true);
        }

    }

    private void SetSectionBar(Context context)
    {
        //设置第一列 的信息
        SectionLayout = new LinearLayout(context);
        SectionLayout.setOrientation(LinearLayout.VERTICAL);
        SectionLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Bottom_Section_rate));
        for(int i=0;i<13;i++) {
            SectionButton[i] = new BootstrapButton(context);
            SectionButton[i].setText((i + 1) + "");
            SectionButton[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Lesson_Width));
            SectionButton[i].setShowOutline(true);
            SectionButton[i].setBootstrapSize(0.55f);
            SectionLayout.addView(SectionButton[i]);
        }

    }
    private void SetBottmBar(Context context)
    {
        BottmLayout = new LinearLayout(context);
        BottmLayout.setOrientation(LinearLayout.HORIZONTAL);
        BottmLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        BottmLayout.addView(SectionLayout);

        LessonsLayout = new LinearLayout(context);
        LessonsLayout.setOrientation(LinearLayout.HORIZONTAL);
        LessonsLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,Botton_Lesson_rate));

        for(int i=0;i<7;i++) {
            LessonLayout[i] = new RelativeLayout(context);
            LessonLayout[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Lesson_Weight));
            LessonsLayout.addView(LessonLayout[i]);
        }
        BottmLayout.addView(LessonsLayout);
    }
}
