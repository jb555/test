package com.example.brazz.jiajian11.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brazz.jiajian11.R;
import com.example.brazz.jiajian11.view.GUI_widget.KeBiaoMssg;
import com.example.brazz.jiajian11.view.GUI_widget.KechenBiao;

/**
 * Created by BrazZ on 2016/3/13.
 */
public class Kebiao_fragment extends Fragment {
    private View mView;
    private KechenBiao test;

    public Kebiao_fragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        mView = layoutInflater.inflate(R.layout.kebiao_fragment,null);
        test = (KechenBiao)mView.findViewById(R.id.kebiao);
        KeBiaoMssg keBiaoMssg1 = new KeBiaoMssg(1,"SB","404","软",5,2);
        KeBiaoMssg keBiaoMssg2 = new KeBiaoMssg(1,"sa","401","a",5,4);

        test.SetCourseMessage(keBiaoMssg1);
        test.SetCourseMessage(keBiaoMssg2);


        KeBiaoMssg keBiaoMssg3 = new KeBiaoMssg(4,"SB","404","软件工程1111111111111111111111",3,2);
        KeBiaoMssg keBiaoMssg4 = new KeBiaoMssg(4,"sa","401","aa",7,3);
        test.SetCourseMessage(keBiaoMssg3);
        test.SetCourseMessage(keBiaoMssg4);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup viewGroup = (ViewGroup)mView.getParent();
        return mView;
    }
}
