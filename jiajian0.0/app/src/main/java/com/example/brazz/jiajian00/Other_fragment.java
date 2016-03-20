package com.example.brazz.jiajian00;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BrazZ on 2016/3/13.
 */
public class Other_fragment extends Fragment {
    private View mView;

    Other_fragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        mView = layoutInflater.inflate(R.layout.other_fragment,null);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       /* ViewGroup viewGroup = (ViewGroup)mView.getParent();
        if(viewGroup == null)
        {
            viewGroup.removeAllViewsInLayout();
        }*/
        return mView;
    }
}
