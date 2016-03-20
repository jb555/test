package com.example.brazz.jiajian00;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BrazZ on 2016/3/13.
 */
public class FirstPage_fragment extends Fragment {

    private ListView Todaycourse_list;

    private View mView;

    private FirstPageCourse_Adapter fa;


    private ArrayList<KeBiaoMssg> TodayCourse;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        mView = layoutInflater.inflate(R.layout.firstpage_fragment,null);

        Todaycourse_list = (ListView)mView.findViewById(R.id.listView);
        TodayCourse = new ArrayList<KeBiaoMssg>();

        KeBiaoMssg course1 = new KeBiaoMssg("蔡明","主5#408","C++",1,2);
        TodayCourse.add(course1);
        KeBiaoMssg course2 = new KeBiaoMssg("张思民","主5#417","Android程序设计",3,4);
        TodayCourse.add(course2);
        KeBiaoMssg course3 = new KeBiaoMssg("张津蕾","公一#108","汽车概论",7,8);
        TodayCourse.add(course3);
        KeBiaoMssg course4 = new KeBiaoMssg("黄彪","理工#406","网络安全",9,11);
        TodayCourse.add(course4);

        fa = new FirstPageCourse_Adapter(getActivity(),TodayCourse);

        Todaycourse_list.setAdapter(fa);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return mView;
    }
}

class FirstPageCourse_Adapter extends BaseAdapter
{


    private Context context;
    private ArrayList<KeBiaoMssg> keBiaoMssgArrayList;

    FirstPageCourse_Adapter(Context context,ArrayList<KeBiaoMssg> keBiaoMssgArrayList){
        this.context = context;
        this.keBiaoMssgArrayList = keBiaoMssgArrayList;
    }


    @Override
    public int getCount() {
        return keBiaoMssgArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return keBiaoMssgArrayList.get(position).CourseName;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.firstpage_course_adapter,null);
        }
        TextView CourseName = (TextView)convertView.findViewById(R.id.textView3);
        CourseName.setText(keBiaoMssgArrayList.get(position).CourseName);

        TextView Teacher = (TextView)convertView.findViewById(R.id.textView6);
        Teacher.setText(keBiaoMssgArrayList.get(position).Teacher);

        TextView JieCi = (TextView)convertView.findViewById(R.id.textView4);
        JieCi.setText(keBiaoMssgArrayList.get(position).Section + "~"+keBiaoMssgArrayList.get(position).Jieshu+"节");

        TextView Place = (TextView)convertView.findViewById(R.id.textView5);
        Place.setText(keBiaoMssgArrayList.get(position).Place);


         return convertView;
    }

}
