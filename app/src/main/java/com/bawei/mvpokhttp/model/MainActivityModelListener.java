package com.bawei.mvpokhttp.model;

import com.bawei.mvpokhttp.bean.Qbean;

/**
 * Created by Administrator on 2017/10/14.
 */

public interface MainActivityModelListener {

    public void callBackSuccess(Qbean qbean);
    public void callBackFailure(int code);
}
