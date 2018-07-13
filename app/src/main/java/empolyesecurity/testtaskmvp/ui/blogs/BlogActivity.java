/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package empolyesecurity.testtaskmvp.ui.blogs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import empolyesecurity.testtaskmvp.MvpApp;
import empolyesecurity.testtaskmvp.R;
import empolyesecurity.testtaskmvp.data.dp.model.DaoSession;
import empolyesecurity.testtaskmvp.data.network.model.Blog;
import empolyesecurity.testtaskmvp.data.network.model.BlogDao;
import empolyesecurity.testtaskmvp.ui.base.BaseActivity;


/**
 * Created by janisharali on 25/05/17.
 */

public class BlogActivity extends BaseActivity implements
        BlogMvpView, BlogAdapter.Callback {

    private static final String TAG = "BlogActivity";

    @Inject
    BlogMvpPresenter<BlogMvpView> mPresenter;

    @Inject
    BlogAdapter mBlogAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.blog_recycler_view)
    RecyclerView mRecyclerView;

    private Query<Blog> notesQuery;


    public static BlogDao blogDao;
/*
    public static BlogActivity newInstance() {
        Bundle args = new Bundle();
        BlogActivity fragment = new BlogActivity();
        fragment.setArguments(args);
        return fragment;
    }
*/
public static Intent getStartIntent(Context context) {
    Intent intent = new Intent(context, BlogActivity.class);
    return intent;
}
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blog);


        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        DaoSession mDaoSession = ((MvpApp) getApplication()).getDaoSession();
        blogDao = mDaoSession.getBlogDao();
      //  notesQuery = blogDao.queryBuilder().orderAsc(BlogDao.Properties.Title).build();
        if (MvpApp.checkConnection(BlogActivity.this)) {
            // Its Available...



                mBlogAdapter.setCallback(this);




                setUp();


           // volleyJsonParse();
            Toast.makeText(BlogActivity.this, "Available", Toast.LENGTH_SHORT).show();


        } else {

                mBlogAdapter.setCallback(this);

                mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(mBlogAdapter);



              mPresenter.onBlogDb();





            Toast.makeText(BlogActivity.this, "Not Available", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void setUp() {




        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);

       mPresenter.onViewPrepared();

       // mPresenter.onBlogDb();
    }

    @Override
    public void onBlogEmptyViewRetryClick() {

        System.out.println("55555555555555");
    }

    @Override
    public void updateBlog(List<Blog> blogList) {

        System.out.println("22222222222"+blogList.size());
        mBlogAdapter.addItems(blogList);
    }

    @Override
    public void blogDp() {


       // mBlogAdapter.addItems(blogList);
        List<Blog> contacts = blogDao.loadAll();;
        System.out.println("valuessssssssssss+"+contacts.size());



        if (contacts.size() > 0) {
            mBlogAdapter.addItems(contacts);

            }
       // System.out.println("1111111111"+blogList.size());
    }


    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }



    public void databaseValues(){





    }

}
