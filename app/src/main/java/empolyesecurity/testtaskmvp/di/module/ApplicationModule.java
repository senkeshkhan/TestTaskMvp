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

package empolyesecurity.testtaskmvp.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import empolyesecurity.testtaskmvp.BuildConfig;
import empolyesecurity.testtaskmvp.MvpApp;
import empolyesecurity.testtaskmvp.data.AppDataManager;
import empolyesecurity.testtaskmvp.data.DataManager;


import empolyesecurity.testtaskmvp.data.dp.AppDbHelper;
import empolyesecurity.testtaskmvp.data.dp.DbHelper;
import empolyesecurity.testtaskmvp.data.network.APIService;
import empolyesecurity.testtaskmvp.data.network.ApiHeader;
import empolyesecurity.testtaskmvp.data.prefs.AppPreferencesHelper;
import empolyesecurity.testtaskmvp.data.prefs.PreferencesHelper;
import empolyesecurity.testtaskmvp.di.ApiInfo;
import empolyesecurity.testtaskmvp.di.ApplicationContext;
import empolyesecurity.testtaskmvp.di.DatabaseInfo;
import empolyesecurity.testtaskmvp.di.PreferenceInfo;
import empolyesecurity.testtaskmvp.utils.AppConstants;


/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final MvpApp mApplication;



   /* public ApplicationModule(Application application) {
        mApplication = application;
    }*/
    public ApplicationModule(MvpApp baseApplication) {
        this.mApplication = baseApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }
    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }
    @Provides
    @Singleton
    public APIService provideApiService() {
        return APIService.Factory.create(mApplication);
    }
   /* @Provides
    @Singleton
    public ApiHelper provideApiService() {
        return ApiHelper.Factory.create(mApplication);
    }*/
    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }
    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
    /*@Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }*/
    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    /*@Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }*/
}
