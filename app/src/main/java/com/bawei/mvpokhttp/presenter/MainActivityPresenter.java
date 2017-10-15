package com.bawei.mvpokhttp.presenter;

import com.bawei.mvpokhttp.bean.Qbean;
import com.bawei.mvpokhttp.model.MainActivityModel;
import com.bawei.mvpokhttp.model.MainActivityModelListener;
import com.bawei.mvpokhttp.view.MainActivityviewListener;

/**
 * Created by Administrator on 2017/10/14.
 */

public class MainActivityPresenter {

    private MainActivityviewListener mainActivityviewListener;
    private MainActivityModel model;

    public MainActivityPresenter(MainActivityviewListener mainActivityviewListener) {
      this.mainActivityviewListener=mainActivityviewListener;
   this.model=new MainActivityModel();
    }
    public void getData(boolean up){
           model.getData(up, new MainActivityModelListener() {
               @Override
               public void callBackSuccess(Qbean qbean) {
                           mainActivityviewListener.callBackSuccess(qbean);
               }

               @Override
               public void callBackFailure(int code) {
                 mainActivityviewListener.callBackFailure(code);
               }
           });

    }



}
