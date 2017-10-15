package com.bawei.mvpokhttp.model;

import com.bawei.mvpokhttp.LogInterceptor;
import com.bawei.mvpokhttp.bean.Qbean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/14.
 */

public class MainActivityModel {



    public void getData(boolean up, final MainActivityModelListener mainActivityModelListener){
               OkHttpClient builder = new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build();

        final Request request = new Request.Builder().url("http://api.expoon.com/AppNews/getNewsList/type/1/p/1").build();
              builder.newCall(request).enqueue(new Callback() {
                  @Override
                  public void onFailure(Call call, IOException e) {
                              mainActivityModelListener.callBackFailure(1);
                  }

                  @Override
                  public void onResponse(Call call, Response response) throws IOException {
                      String result = response.body().string();
                      Gson gson=new Gson();
                      Qbean qbean = gson.fromJson(result, Qbean.class);
                      mainActivityModelListener.callBackSuccess(qbean);
                  }
              });
    }
}
