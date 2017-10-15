package com.bawei.mvpokhttp.view;

import com.bawei.mvpokhttp.bean.Qbean;

/**
 * Created by Administrator on 2017/10/14.
 */

public interface MainActivityviewListener {

    public void callBackSuccess(Qbean qbean);
    public void callBackFailure(int code);

}
