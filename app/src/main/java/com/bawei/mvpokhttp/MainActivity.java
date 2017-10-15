package com.bawei.mvpokhttp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.bawei.mvpokhttp.bean.Qbean;
import com.bawei.mvpokhttp.presenter.MainActivityPresenter;
import com.bawei.mvpokhttp.view.MainActivityviewListener;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityviewListener{
    MainActivityPresenter presenter;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.springview)
    SpringView springview;
    private Iadapter iadapter;
    private StaggeredGridLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        springview.setHeader(new MeituanHeader(this));
        springview.setFooter(new MeituanFooter(this));

         presenter=new MainActivityPresenter(this);


        manager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recycleview.setLayoutManager(manager);

        iadapter=new Iadapter(this);
        recycleview.setAdapter(iadapter);

        HorizontalDividerItemDecoration horizontalDividerItemDecoration =  new HorizontalDividerItemDecoration.Builder(this)
                .color(Color.RED)
//                .sizeResId(R.dimen.divider)
//                .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                .build() ;
        recycleview.addItemDecoration(horizontalDividerItemDecoration);
        presenter.getData(true);



        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {

                presenter.getData(true);



            }

            @Override
            public void onLoadmore() {
                presenter.getData(true);

            }
        });

    }

    @Override
    public void callBackSuccess(final Qbean qbean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                iadapter.setData(qbean);
                springview.onFinishFreshAndLoad();

            }
        });


    }

    @Override
    public void callBackFailure(int code) {

    }
}
